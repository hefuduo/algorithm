package kotlinimpl

import java.lang.StringBuilder

/**com.github.hefuduo.chapter3
 * Created by hefuduo on 2019-10-11.
 */

/**
 * 3.1
 * l 和 p 是有序链表, 输出l中p存储的index
 * @param l List<Int>
 * @param p List<Int>
 */
fun printLots(l: List<Int>, p: List<Int>) {
    p.forEach {
        println(l[it])
    }
}

/**
 * 3.2
 *使用单链表或双链表交换相邻元素 (调整链而不是数据)
 */


open class Node<E> internal constructor(
        var item: E?,
        var next: Node<E>?,
        var prev: Node<E>?
)

fun <E> Node<E>.printList() {
    var r: Node<E>? = this
    val builder: StringBuilder = StringBuilder()
    builder.append("[")
    while (r != null) {
        builder.append(r.item)
        builder.append(",")
        r = r.next
    }
    builder.append("]")
    println(builder)
}

/**
 * 单链表
 * @param beforeP Node<E> 要交换的两个元素的前向节点.
 */
fun <E> switchWithNext(beforeP: Node<E>) {
    val a = beforeP.next
    val b = beforeP.next?.next
    if (b == null) {
        beforeP.next = null
        return
    }
    beforeP.next = b
    a?.next = b.next
    b.next = a
}

/**
 * 双链表
 * @param node2 Node2<E>
 */
fun <E> switchWithNext2(beforeP: Node<E>) {
    val a = beforeP.next
    val b = beforeP.next?.next
    if (b == null) {
        beforeP.next = null
        return
    }
    a?.prev?.next = b
    b.prev = a?.prev
    b.next?.prev = a
    a?.next = b.next
    b.next = a
}


/**
 * 3.4
 * 已经排序的表1 表2, 只使用基本操作求L1 交 L2
 * @param l1 List<E> 表1
 * @param l2 List<E> 表2
 */
fun <E : Comparable<E>> interSection(l1: List<E>, l2: List<E>): List<E> {
    var p1: E? = null
    var p2: E? = null
    var it1 = l1.iterator()
    var it2 = l2.iterator()
    val result = ArrayList<E>()
    if (it1.hasNext() && it2.hasNext()) {
        p1 = it1.next()
        p2 = it2.next()
    }
    while (p1 != null && p2 != null) {
        when {
            p1 == p2 -> {
                result.add(p1)
                //同时移动p1, p2
                p1 = if (it1.hasNext()) it1.next() else null
                p2 = if (it1.hasNext()) it2.next() else null
            }
            p1 > p2 -> //p1大,只移动p1
                p2 = if (it2.hasNext()) it2.next() else null
            p1 < p2 -> //p2大,只移动p2
                p1 = if (it1.hasNext()) it1.next() else null
        }
    }
    return result
}

/**
 * 3.5
 * 求两个表的并集
 * @param l1 List<E>
 * @param l2 List<E>
 * @return List<E>
 */
fun <E : Comparable<E>> union(l1: List<E>, l2: List<E>): List<E> {
    var p1: E? = null
    var p2: E? = null
    var it1 = l1.iterator()
    var it2 = l2.iterator()
    val result = ArrayList<E>()
    if (it1.hasNext() && it2.hasNext()) {
        p1 = it1.next()
        p2 = it2.next()
    }
    while (p1 != null && p2 != null) {
        when {
            p1 == p2 -> {
                result.add(p1)
                //同时移动p1, p2
                p1 = if (it1.hasNext()) it1.next() else null
                p2 = if (it1.hasNext()) it2.next() else null
            }

            p1 > p2 -> {
                //最终的结果还是一个排序数组,因此,先将p2插入
                result.add(p2)
                //移动p2
                p2 = if (it1.hasNext()) it2.next() else null
            }

            p1 < p2 -> {
                result.add(p1)
                //移动p1
                p1 = if (it1.hasNext()) it1.next() else null
            }
        }
    }
    if (p1 != null)
        result.add(p1)
    while (it1.hasNext()) {
        result.add(it1.next())
    }
    if (p2 != null)
        result.add(p2)
    while (it2.hasNext()) {
        result.add(it2.next())
    }
    return result
}

/**
 * 3.6 约瑟夫环问题的链表实现
 * @param m Int
 * @param n Int
 * @return Int
 */

fun josephusWithCircleList(m: Int, n: Int): Int {
    val head: Node<Int>? = Node(1, null, null)
    var x: Node<Int>? = head
    //构造一个环形的链表
    for (i in 2..n + 1) {
        x?.next = Node(i, null, null)
        if (i == n + 1) {
            x?.next = head
            break
        }
        x = x?.next
    }
    var prev: Node<Int>? = x
    var size = n
    while (size > 1) {
        size--
        var i = m % n
        while (i-- > 0) {
            prev = prev?.next
        }
        var next = prev?.next
        //remove next
        prev?.next = next?.next
        next?.next = null
    }
    return if (prev?.item != null) {
        prev.item!!.toInt()
    } else {
        -1
    }
}


/**
 * 3.6 约瑟夫环问题数组实现 FIXME 没有完成
 * @param m Int 传递间隔次数
 * @param n Int 编号 1~n
 * @return 返回谁胜利了.
 */
fun josephus(m: Int, n: Int): Int? {
    val a: Array<Int>? = Array(n) {
        return@Array it + 1
    }
    a?.forEach {
        println(it)
    }

    val step = m % n
    var cur = 0
    var index = 0
    var size = a?.size

    while (size!! > 1) {
        index = cur + step
        if (index > size) {
            index %= size
        }
        for (i in index until size - 1) {
            a!![i] = a[i + 1]
        }
        size -= 1
//        a.remove(index) curIndex --
        cur = index
        if (cur > size - 1)
            cur = cur - size + 1
    }

    return a?.get(0)
}


/*
 *3.7 O(n^2)
 *
 */


/**
 *  3.11
 *  打印单链表的长度.
 * @param head Node<E>
 * @return Int
 */
fun <E> sizeOfList(head: Node<E>): Int {
    var i = 1
    var x = head
    while (x.next != null) {
        i++
        x = x.next!!
    }
    return i
}

/**
 * 3.11 测试x是否包含于链表的方法
 * @param element E?
 * @param head Node<E>
 * @return Boolean
 */
fun <E : Comparable<E>> listContains(element: E?, head: Node<E>): Boolean {
    var x = head
    //这里注意element为null的情况
    if (element == null) {
        while (x.next != null) {
            if (x.item == null)
                return true
            x = x.next!!
        }
    } else {
        while (x.next != null) {
            if (x.item == element)
                return true
            x = x.next!!
        }
    }
    return false
}

/**
 * 如果x不含于链表, 添加x
 * @param element E?
 * @param head Node<E>
 */
fun <E : Comparable<E>> addToListIfNotContains(element: E?, head: Node<E>) {
    if (!listContains(element, head)) {
        var x = head
        //找到最后一个
        while (x.next != null) {
            x = x.next!!
        }
        //添加
        x.next = Node(element, null, null)
    }
}

/**
 * 如果x包含于链表中, 从链表中删除x
 * @param element E?
 * @param head Node<E>
 */
fun <E : Comparable<E>> removeFromListIfContains(element: E?, head: Node<E>) {
    if (listContains(element, head)) {
        var x = head
        var prev = x
        if (element == null) {
            while (x.next != null) {
                if (x.item == null)
                    break
                prev = x
                x = x.next!!
            }
        } else {
            while (x.next != null) {
                if (x.item == element)
                    break
                prev = x
                x = x.next!!
            }
        }
        prev.next = x.next
        x.next = null
    }
}

//3.12 如果链表是有序链表, 那么重复3.11的操作应该怎么写程序呢?


//3.26 使用数组实现三个栈结构

class Stack<E : Comparable<E>>(private var capacity: Int) {
    class Index<E>(val index: Int? = 0, element: E?, next: Index<E>?, prev: Index<E>?) : Node<E>(element, next, prev)

    private var data: Array<Node<E>> = Array(capacity) {
        Node<E>(null, null, null)
    }


    //size of array
    private var size: Int = 0

    //stack1 and size
    var stack1: Node<E> = Node(null, null, null)
    var size1 = 0
    //same as above
    var stack2: Node<E> = Node(null, null, null)
    var size2 = 0
    //same as above
    var stack3: Node<E> = Node(null, null, null)
    var size3 = 0
    private var indexToInsert: Index<E> = Index(0, null, null, null)

    init {
        stack2.next = stack1.next
        stack3.next = stack2.next
        stack3.next = data[0]
        indexToInsert.next = data[0]
    }

    /**
     * 始终指向下一个即将被插入的位置
     * 如果 = size 那么三个栈都满.
     */

    fun push(stack: Node<E>, element: E?): Boolean {
        if (size == capacity)
            return false
        else {
            var top = stack
            data[indexToInsert.index!!] = Node(element, null, null)
            top = top.next!!
            size++
        }
        return false;
    }


    fun pop(stack: Node<E>): E? {
        var top: Node<E>? = stack
        val value = top?.item
        top = top?.prev

        return value
    }

    fun peek(stack: Node<E>) {

    }

    fun clear(stack: Node<E>) {

    }

}


/**
 * =================扩展=======================
 */

//单链表的冒泡排序

fun <E: Comparable<E>> bubbleSort(head: Node<E>?): Node<E>? {
    val pHead = head;
    var tail: Node<E>? = pHead
    var p: Node<E>? = pHead
    var prev: Node<E>? = p
    while (tail?.next != null)
        tail = tail.next
    while (tail != pHead) {
        while (p != tail) {
            if (p?.item != null && p.next?.item != null){
                if (p.item!! > p.next!!.item!!){
                    val temp = p.item
                    p.item = p.next!!.item
                    p.next!!.item = temp
                }
                prev = p
                p = p.next
            }
        }
        tail = prev
        p = pHead
    }
    return head
}
