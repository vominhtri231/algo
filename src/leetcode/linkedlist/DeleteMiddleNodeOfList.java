package leetcode.linkedlist;


public class DeleteMiddleNodeOfList {

    public ListNode deleteMiddle(ListNode head) {
        ListNode frond = new ListNode(0, head);
        ListNode slow = frond;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return frond.next;
    }
}
