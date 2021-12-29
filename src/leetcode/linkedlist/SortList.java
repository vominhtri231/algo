package leetcode.linkedlist;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] halves = breakInHalf(head);
        ListNode firstHalf = sortList(halves[0]);
        ListNode secondHalf = sortList(halves[1]);
        return merge(firstHalf, secondHalf);
    }

    private ListNode[] breakInHalf(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondNode = slow.next;
        slow.next = null;
        return new ListNode[]{head, secondNode};
    }

    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode frond = new ListNode(0);
        ListNode cur = frond;

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                cur.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                cur.next = secondHalf;
                secondHalf = secondHalf.next;
            }
            cur = cur.next;
        }

        while (firstHalf != null) {
            cur.next = firstHalf;
            firstHalf = firstHalf.next;
            cur = cur.next;
        }

        while (secondHalf != null) {
            cur.next = secondHalf;
            secondHalf = secondHalf.next;
            cur = cur.next;
        }

        return frond.next;
    }
}
