package others;

public class RemoveFromList {

    // Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> pre = new ListNode<>(0), cur = l, init = pre;
        pre.next = cur;

        while (cur != null) {
            if (cur.value == k) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return init.next;
    }

    ListNode<Integer> create(int[] as) {
        ListNode<Integer> res = new ListNode<>(0);
        ListNode<Integer> cur = res;
        for (int a : as) {
            ListNode<Integer> next = new ListNode<>(a);
            cur.next = next;
            cur = next;
        }
        return res.next;
    }


    public static void main(String[] args) {
        RemoveFromList removeFromList = new RemoveFromList();
        removeFromList.removeKFromList(removeFromList.create(new int[]{3, 1, 2, 3, 4, 5}), 3);
    }
}
