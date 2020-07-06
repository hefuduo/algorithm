import util.ListNode

/**
 * Created by hefuduo on 3/22/20.
 */

//删除链表的倒数第N个节点

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var _n = n
    if (head == null)
        return null
    var p1 = head
    var p2 = head
    while (n > 0) {
        p2 = p2?.next
        _n -= 1
    }
    while (p2?.next != null) {
        p2 = p2.next
        p1 = p1?.next
    }
    val temp = p1?.next
    p1?.next = temp?.next
    return head
}
