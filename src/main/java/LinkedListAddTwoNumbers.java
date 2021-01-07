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
public class LinkedListAddTwoNumbers {

    class ListNode {
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


/*    Runtime: 0 ms
    Memory Usage: 38.8 MB*/
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while(head != null){
            // Saving link to the node next after current one
            ListNode temp = head.next;
            // linking current head of the reversed Linked list as next for current node
            head.next = rev;
            // assigning the current node as the head object of the reversed Linked list
            rev = head;
            // Saving next node as current object
            head = temp;
        }
        return rev;
    }

    private ListNode rev(ListNode head, ListNode rev) {
        // Saving link to the node next after current one
        ListNode temp = head.next;
        // linking current head of the reversed Linked list as next for current node
        head.next = rev;
        // assigning the current node as the head object of the reversed Linked list
        rev = head;
        // Saving next node as current object
        head = temp;
        if (head == null) return rev;
        return rev(head, rev);
    }

/*    Runtime: 0 ms
    Memory Usage: 39.1 MB*/
    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        return rev(head, null);
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

/*    Runtime: 0 ms
    Memory Usage: 38.2 MB*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, tmp;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;

            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }

        if (l1 == null) {
            tmp.next = l2;
        } else {
            tmp.next = l1;
        }
        return head;
    }

/*  You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
            Constraints:

    The number of nodes in each linked list is in the range [1, 100].
            0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.*/

    /*1568 / 1568 test cases passed.
            Status: Accepted
    Runtime: 2 ms
    Memory Usage: 39.3 MB*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, carry = 0;
        ListNode fakeHead, tmp;
        fakeHead = new ListNode(-1);
        tmp = fakeHead;
        while (l1 != null || l2 != null) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = (sum / 10) > 0 ? 1 : 0;
            tmp.next = new ListNode(sum % 10);
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            tmp = tmp.next;
        }
        if (carry == 1)  tmp.next = new ListNode(1);
        return fakeHead.next;
    }

    /*1568 / 1568 test cases passed.
            Status: Accepted
    Runtime: 2 ms
    Memory Usage: 39.6 MB*/
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean overfloor = false;
        int sum,remainder;
        ListNode sumHead, tmp = null;
        if (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            if (sum > 0) {
                remainder = sum % 10;
                overfloor = (sum / 10) > 0;
            } else remainder = 0;
            sumHead = new ListNode(remainder);
            tmp = sumHead;
        } else return tmp;

        while (l1.next != null && l2.next != null) {
            sum = l1.next.val + l2.next.val;
            if (overfloor) {
                sum++;
                overfloor = false;
            }
            if (sum > 0) {
                remainder = sum % 10;
                overfloor = (sum / 10) > 0;
            } else remainder = 0;
            tmp.next = new ListNode(remainder);
            l1 = l1.next;
            l2 = l2.next;
            tmp = tmp.next;
        }
        if (l1.next != null || l2.next != null) {
            ListNode remainderList;
            if (l1.next != null) {
                remainderList = l1.next;
            } else remainderList = l2.next;
            while (remainderList != null) {
                sum = remainderList.val;
                if (overfloor) {
                    sum++;
                    overfloor = false;
                }
                if (sum > 0) {
                    remainder = sum % 10;
                    overfloor = (sum / 10) > 0;
                } else remainder = 0;
                tmp.next = new ListNode(remainder);
                remainderList = remainderList.next;
                tmp = tmp.next;
            }
        }
        if(overfloor) {
            tmp.next = new ListNode(1);
        }
        return sumHead;
    }

    public static void main(String[] args) {
        LinkedListAddTwoNumbers t = new LinkedListAddTwoNumbers();
        ListNode one = t.new ListNode(6);
        ListNode two = t.new ListNode(2);
        ListNode three = t.new ListNode(2);
        ListNode four = t.new ListNode(9);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        ListNode copy = t.reverseListCopy(one);
        ListNode addList = t.addTwoNumbers(one, copy);
        testNodes(one, copy, addList);

        ListNode five = t.new ListNode(9);
        four.next = five;
        addList = t.addTwoNumbers(one, copy);
        testNodes(one, copy, addList);
    }

    private static void testNodes(ListNode firstList, ListNode secondList, ListNode firdList) {

        System.out.println("First Linked List");
        System.out.println(firstList);
        System.out.println("--------------------------");
        System.out.println("Second Linked List");
        System.out.println(secondList);
        System.out.println("--------------------------");
        System.out.println("Fird Linked List");
        System.out.println(firdList);
        System.out.println("--------------------------");
    }
}
