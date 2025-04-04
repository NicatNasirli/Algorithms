package algorithms.leetcode.topInterview150;


public class LinkedListCycle {

    /*
    Given head, the head of a linked list, determine if the linked list has a cycle in it.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
    Note that pos is not passed as a parameter.

    Return true if there is a cycle in the linked list. Otherwise, return false.
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();

        linkedListCycle.main();

    }

    public void main() {
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;


        node4.next = node2;
        System.out.println(hasCycle(head1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowCycle = head;
        ListNode fastCycle = head;

        while (fastCycle != null && fastCycle.next != null) {
            slowCycle = slowCycle.next;
            fastCycle = fastCycle.next.next;

            if (slowCycle == fastCycle) return true;
        }

        return false;
    }
}
