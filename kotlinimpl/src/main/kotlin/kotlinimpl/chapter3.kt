package kotlinimpl

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
 *使用单链表或双链表交换相邻元素 (调整链而不是数据)
 */


class Node<E> internal constructor(
        val item: E?,
        var next: Node<E>?,
        var prev: Node<E>?
)

fun <E> Node<E>.printList() {
    var r: Node<E>? = this
    while (r?.next != null) {
        println(r.item)
        r = r.next
    }
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
 * 约瑟夫环问题数组实现 FIXME 没有完成
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

