package kotlinimpl

//堆数据结构 的 增删改查
/**
 *
 * @property capacity Int
 * @property size Int
 * @property a IntArray?
 * @constructor
 */
class Heap constructor(val capacity: Int) {
    private var size: Int = 0

    lateinit var a: IntArray

    init {
        a = IntArray(capacity)
        size = 0
    }

    constructor(src: IntArray) : this((src.size / 0.75).toInt()) {
        size = src.size
        a = src
    }

    fun left(index: Int): Int {
        return 2 * index + 1;
    }

    fun right(index: Int): Int {
        return 2 * index + 2;
    }

    fun parent(index: Int): Int {
        return if (index == 0) {
            -1
        } else {
            (index - 1) / 2;
        }
    }

    /**
     * 大根堆
     * @param src IntArray 源数据
     */
    fun maxHeapify(i: Int) {
        if (a.isEmpty()) {
            return
        }
        val l = left(i)
        val r = right(i)
        var m = 0
        var temp = 0
        //找到三个元素中最大的那个,并且跟parent交换
        m = if (l < size && a[i] < a[l]) l else i
        m = if (r < size && a[m] < a[r]) r else m
        if (i != m) {
            //交换两个元素
            temp = a[i]
            a[i] = a[m]
            a[m] = temp
            //交换后,被交换的元素可能还是不满足大根堆的条件, 继续变化
            maxHeapify(m)
        }
    }

    fun minHeapify(i: Int) {
        if (a.isEmpty()) {
            return
        }
        val l = left(i)
        val r = right(i)
        var m = 0
        var temp = 0
        //找到三个元素中最小的那个,并且跟parent交换
        m = if (l < size && a[i] > a[l]) l else i
        m = if (r < size && a[m] > a[r]) r else m
        if (i != m) {
            //交换两个元素m
            temp = a[i]
            a[i] = a[m]
            a[m] = temp
            //交换后,被交换的元素可能还是不满足大根堆的条件, 继续变化
            minHeapify(m)
        }
    }

    /**
     * 创建大根堆
     * @param a IntArray
     */
    fun buildMaxHeap() {
        if (a.isEmpty()) {
            return
        }
        val n = parent(size - 1);
        for (i in n downTo 0) {
            maxHeapify(i)
        }
    }

    fun buildMinHeap() {
        if (a.isEmpty())
            return

        val n = parent(size - 1)
        for (i in n downTo 0)
            minHeapify(i)
    }

    //todo 格式化打印一个堆!!
    override fun toString(): String {
        if (a.isEmpty())
            return "empty"
        return a.contentToString()
    }

    fun insert(data: Int) {
        if (size + 1 >= capacity) {
            //扩容
        }
        var hole = ++size
        //向上查找
        while (hole > 1 && data < a[hole / 2]) {
            a[hole] = a[hole / 2]
            hole /= 2
        }
        a[hole] = data
    }

    public fun printTree() {

    }
}
