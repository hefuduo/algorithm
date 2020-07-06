import util.ListNode

/**
 * Created by hefuduo on 2/4/20.
 */

fun main(args: Array<String>) {

}



/**
 * 直接合并.
 * @param l1 ListNode?
 * @param l2 ListNode?
 * @return ListNode?
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null || l2 == null) {
        return l1 ?: l2
    }
    var p1 = l1
    var p2 = l2
    var p3 = ListNode(Int.MIN_VALUE)
    var head = p3
    while (p1 != null && p2 != null) {
        if (p1.`val` > p2.`val`) {
            p3.next = p2
            p3 = p3.next!!
            p2 = p2.next
        } else if (p1.`val` <= p2.`val`) {
            p3.next = p1
            p3 = p3.next!!
            p1 = p1.next
        }
    }
    if (p1 != null) {
        p3.next = p1
    }
    if (p2 != null) {
        p3.next = p2
    }
    return head.next
}
