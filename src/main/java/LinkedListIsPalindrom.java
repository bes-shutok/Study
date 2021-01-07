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
public class LinkedListIsPalindrom {

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


    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        ListNode cur = head;
        while(cur!=null){
            // Saving link to the node next after current one
            ListNode temp = cur.next;
            // linking current head node of the reversed Linked list as next for current
            cur.next = rev;
            // assigning the current node as the head object of the reversed Linked list
            rev = cur;
            // Saving next node as current object
            cur = temp;
        }
        return rev;
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

    public ListNode removeElements(ListNode head, int val) {
        // Let's make sure the head does not have the val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return null;
        // Let's check following nodes
        ListNode nextHead = head;
        while (nextHead.next != null) {


            // Let's test node after nextNode
            if (nextHead.next.val == val) {
                nextHead.next = nextHead.next.next;
            } else nextHead = nextHead.next;
        }
        return head;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while (even.next != null && even.next.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        if (even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = null;
        }
        odd.next = evenHead;
        return head;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode rev = reverseListCopy(head);
        ListNode node = head;
        ListNode revNode = rev;
        while (node != null) {
            if (node.val != revNode.val) return false;
            node = node.next;
            revNode = revNode.next;
        }
        return true;
    }

    /*    26 / 26 test cases passed.
    Status: Accepted
    Runtime: 1 ms
    Memory Usage: 41.4 MB*/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        ListNode rev = reverseList(slow);
        while (fast.next != null) {
            if (fast.val != rev.val) {
                return false;
            }
            fast = fast.next;
            rev = rev.next;
        }
        return true;
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
        LinkedListIsPalindrom t = new LinkedListIsPalindrom();
        System.out.println("Original Linked List");
        System.out.println(one);
        System.out.println("--------------------------");
        System.out.println("reverseList Linked List");
        System.out.println(t.reverseListCopy(one));
        System.out.println("--------------------------");
        System.out.println("Original Linked List");
        System.out.println(one);
        System.out.println("--------------------------");
        System.out.println("IsPalindromr? " +  t.isPalindrome(one));
    }
}
