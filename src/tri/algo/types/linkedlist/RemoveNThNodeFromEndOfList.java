package tri.algo.types.linkedlist;

public class RemoveNThNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode frond = new ListNode(0, head);
        ListNode slow = frond;
        ListNode fast = frond;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return frond.next;
    }
}
