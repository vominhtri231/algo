package tri.algo.types.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int len = getLength(head);
        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode cur = head;
        int cutPoint = len - k;
        while (cutPoint > 1) {
            cur = cur.next;
            cutPoint--;
        }

        ListNode cutPart = cur.next;
        cur.next = null;
        getTail(cutPart).next = head;
        return cutPart;
    }

    private ListNode getTail(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}
