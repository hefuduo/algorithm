import util.ListNode;

/**
 * PACKAGE_NAME
 * Created by hefuduo on 2/19/20.
 */
public class CircleList {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        for (; ; ) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
            if (slow == fast) {
                return true;
            }
        }
    }
}
