package tri.algo.types.linkedlist;

public class SwapNodesInPair {

    public ListNode swapPairs(ListNode head) {
        ListNode frond = new ListNode(0, head);

        ListNode cur = frond.next;
        ListNode pre = frond;

        while (cur != null && cur.next != null) {
            ListNode partner = cur.next;
            ListNode child = partner.next;

            pre.next = partner;
            partner.next = cur;
            cur.next = child;

            pre = cur;
            cur = child;
        }

        return frond.next;
    }
}
