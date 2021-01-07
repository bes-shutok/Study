/*
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
 *
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LinkedListReversable {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Singly-linked list with \n" +
                    "value = " + this.val + "\n" +
                    "next = " + ((this.next == null) ? "null" : "\n" + this.next.toString());
        }
    }

    public ListNode reverseListCopy(ListNode head) {
        ListNode cur = head  == null ? null : new ListNode(head.val, head.next);
        ListNode rev = null;
        while (cur != null) {
            // Saving link to the copy of node next after current one
            ListNode temp = cur.next == null ? null : new ListNode(cur.next.val,cur.next.next);
            // linking head node of the reversed Linked list as next for current
            cur.next = rev;
            // assigning the current node as the head object of the reversed Linked list
            rev = cur;
            // Saving next node as current object
            cur = temp;
        }
        return rev;
    }

    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        ListNode cur = head;
        while(cur!=null){
            // Saving link to the node next after current one
            ListNode temp = cur.next;
            // linking head node of the reversed Linked list as next for current
            cur.next = rev;
            // assigning the current node as the head object of the reversed Linked list
            rev = cur;
            // Saving next node as current object
            cur = temp;
        }
        return rev;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(-4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        LinkedListReversable t = new LinkedListReversable();
        System.out.println("Original Linked List");
        System.out.println(one);
        System.out.println("--------------------------");
        System.out.println("reverseList Linked List");
        System.out.println(t.reverseListCopy(one));
        System.out.println("--------------------------");
        System.out.println("Original Linked List");
        System.out.println(one);
        System.out.println("--------------------------");
    }
}
