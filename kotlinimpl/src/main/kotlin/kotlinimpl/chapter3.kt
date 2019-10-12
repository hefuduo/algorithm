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

class Node1<E> internal constructor(
    internal var item: E?,
    internal var next: Node1<E>?
)

class Node2<E> internal constructor(
    val item: E?,
    var next: Node2<E>?,
    var prev: Node2<E>?
)

/**
 * 单链表
 * @param beforeP Node<E> 要交换的两个元素的前向节点.
 */
fun <E> switchWithNext(beforeP: Node1<E>) {
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
fun <E> switchWithNext2(node2: Node2<E>) {

}


