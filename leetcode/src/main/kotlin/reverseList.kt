import util.ListNode

/**
 * Created by hefuduo on 3/12/20.
 */

//反转链表

fun main() {

}

//递归的意思：我子节点下的所有节点都已经反转好了，现在就剩我和我的子节点 没有完成最后的反转了，所以反转一下我和我的子节点。
/**
 * 这个思想非常好哈哈哈哈
 * @param head ListNode?
 * @return ListNode?
 */
fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val p = reverseList(head.next)
    head.next!!.next = head
    head.next = null
    return p
}

//迭代法
fun reverseList2(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head
    var pre: ListNode? = head
    var cur = head.next
    head.next = null
    var temp = cur
    while(cur != null) {
        temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}
