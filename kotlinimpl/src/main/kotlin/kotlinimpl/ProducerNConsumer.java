package kotlinimpl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者.
 * kotlinimpl
 * Created by hefuduo on 2019-11-24.
 */
public class ProducerNConsumer {
    public static void main(String[] args) {
        SResource resource = new Resource3();

        Producer p1 = new Producer(resource);
        Producer p2 = new Producer(resource);
        Producer p3 = new Producer(resource);
        Consumer c1 = new Consumer(resource);
        Consumer c2 = new Consumer(resource);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        try {
            Thread.sleep(20_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//实现1 使用 synchronized wait() notifyAll();

abstract class SResource {
    protected int size = 0;

    protected static final int CAPACITY = 20;

    abstract void add();

    abstract void get();
}

class Resource extends SResource {

    @Override
    public synchronized void add() {
        if (size < CAPACITY) {
            size++;
            System.out.println("生产=" + Thread.currentThread().getName());
            System.out.println("当前有" + size + "个资源");
            notifyAll();
        }
        while (size >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void get() {
        if (size > 0) {
            size--;
            System.out.println("消费=" + Thread.currentThread().getName());
            System.out.println("当前有" + size + "个资源");
            notifyAll();
        }
        while (size <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


class Producer extends Thread {
    private SResource mResource;

    public Producer(SResource resource) {
        this.mResource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mResource.add();
        }
    }
}


class Consumer extends Thread {
    private SResource mResource;

    public Consumer(SResource resource) {
        mResource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mResource.get();
        }
    }
}


//lock and Condition
class Resource2 extends SResource {
    Lock mLock;
    private Condition mConsumerCondition;
    private Condition mProducerCondition;

    public Resource2() {
        mLock = new ReentrantLock();
        mConsumerCondition = mLock.newCondition();
        mProducerCondition = mLock.newCondition();
    }

    @Override
    public void add() {
        mLock.lock();
        try {
            if (size < CAPACITY) {
                size++;
                System.out.println("生产=" + Thread.currentThread().getName());
                System.out.println("当前有" + size + "个资源");
                mConsumerCondition.signalAll();
            }
            while (size >= CAPACITY) {
                mProducerCondition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }

    @Override
    public void get() {
        mLock.lock();
        try {
            if (size > 0) {
                size--;
                System.out.println("消费=" + Thread.currentThread().getName());
                System.out.println("当前有" + size + "个资源");
                mProducerCondition.signalAll();
            }
            while (size <= 0) {
                mConsumerCondition.await();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}


//使用阻塞队列, 阻塞队列本身就是一个生产者消费者模式

class Resource3 extends SResource {
    private BlockingQueue mBlockingQueue;

    public Resource3() {
        mBlockingQueue = new ArrayBlockingQueue(CAPACITY);
    }

    @Override
    void add() {
        try {
            mBlockingQueue.put(1);
            size = mBlockingQueue.size();
            System.out.println("生产=" + Thread.currentThread().getName());
            System.out.println("当前有" + size + "个资源");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void get() {
        try {
            mBlockingQueue.take();
            size = mBlockingQueue.size();
            System.out.println("消费=" + Thread.currentThread().getName());
            System.out.println("当前有" + size + "个资源");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


