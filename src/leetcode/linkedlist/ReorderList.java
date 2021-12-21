package leetcode.linkedlist;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode secondHalf = breakInHalf(head); // head is the first half now
        ListNode reveredSecondHalf = reverse(secondHalf);
        merge(head, reveredSecondHalf);
    }

    private ListNode breakInHalf(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        return secondHalf;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nextCur = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextCur;
        }

        return pre;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }

}
