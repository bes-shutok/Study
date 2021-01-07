/*
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
 *
 * */

import java.util.Stack;

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
public class DoublyLinkedMultiLevelList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int x) {
            this.val = x;
            this.next = null;
            this.prev = null;
            this.child = null;
        }

        Node(int x, Node prev) {
            this.val = x;
            this.next = null;
            this.prev = prev;
            this.child = null;
        }

        Node(int x, Node prev, Node next) {
            this.val = x;
            this.next = next;
            this.prev = prev;
            this.child = null;
        }
        Node(int x, Node prev, Node next, Node child) {
            this.val = x;
            this.next = next;
            this.prev = prev;
            this.child = child;
        }

        @Override
        public String toString() {
            return "Multilevel Doubly Linked list #" + this.getClass().getName() + " with \n" +
                    "value = " + this.val + "\n" +
                    "prev value = " + ((this.prev == null) ? "null\n" : this.prev.val + "\n") +
                    "next = " + ((this.next == null) ? "null\n" : "\n" + this.next.toString()) +
                    "child = " + ((this.child == null) ? "null\n" : "\n" + this.child.toString());
        }
    }

    /*    Runtime: 0 ms
    Memory Usage: 38.3 MB*/
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head, tail = null;
        while (cur != null) {
            if (cur.child != null && cur.next != null) {
                if (tail != null) {
                    Node tmp = cur.next;
                    while (tmp.next != null) tmp = tmp.next;
                    tmp.next = tail;
                    tail.prev = tmp;
                }
                tail = cur.next;
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else if (cur.child != null) {
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            if (cur.next == null) {
                cur.next = tail;
                if (tail != null) tail.prev = cur;
                tail = null;
            }
            cur = cur.next;
        }
        return head;
    }

/*    Runtime: 0 ms
    Memory Usage: 38.5 MB*/
    public Node flatten2(Node head) {
        if (head == null) return null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur.child != null || cur.next != null) {
            if (cur.child != null) {
                if (cur.next != null) stack.push(cur.next);
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            } else cur = cur.next;
        }
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur.next.prev = cur;
            while (cur.next != null) cur = cur.next;
        }
        return head;
    }


    public Node flatten3(Node head) {
    recursionFlat(head);
    return head;
}
    /*    Runtime: 1 ms
        Memory Usage: 38.1 MB*/
    private Node recursionFlat(Node cur) {
        if (cur == null) return null;
        boolean hasNext = cur.next != null;
        boolean hasChild = cur.child != null;
        if (hasChild) {
            Node end = recursionFlat(cur.child);
            end.next = cur.next;
            cur.child.prev = cur;
            cur.next = cur.child;
            cur.child = null;
            if (end.next != null) end.next.prev = end;
            return recursionFlat(cur.next);
        } else if (hasNext) {
            return recursionFlat(cur.next);
        } else return cur;
    }

    /*    Runtime: 0 ms
        Memory Usage: 38.6 MB*/
    private Node recursionFlat2(Node cur) {
        if (cur == null) return null;
        boolean hasNext = cur.next != null;
        boolean hasChild = cur.child != null;
        if (hasChild) {
            Node end = recursionFlat(cur.child);
            end.next = cur.next;
            cur.child.prev = cur;
            cur.next = cur.child;
            cur.child = null;
            if (end.next != null) {
                end.next.prev = end;
                return recursionFlat(end.next);
            } else return end;
        } else if (hasNext) {
            return recursionFlat(cur.next);
        } else return cur;
    }


    public static void main(String[] args) {
        DoublyLinkedMultiLevelList t = new DoublyLinkedMultiLevelList();

        Node one = t.new Node(1);
        Node two = t.new Node(2);
        Node three = t.new Node(3);
        Node four = t.new Node(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;
        four.prev = three;
        three.prev = two;
        two.prev = one;


        testNodes(one);

        Node five = t.new Node(5);
        Node six = t.new Node(6);
        Node seven = t.new Node(7);

        two.child = five;
        five.next = six;
        six.next = seven;
        seven.prev = six;
        six.prev = five;

        Node eight = t.new Node(8);
        six.child = eight;
        testNodes(one);
        t.flatten(one);
        testNodes(one);
    }


    private static void testNodes(Node firstList) {
        testNodes(firstList, null, null);
    }
    private static void testNodes(Node firstList, Node secondList, Node firdList) {

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


/*    public Node flatten(Node head) {
        recurseFlatten(head);
        return head;
    }

    public Node recurseFlatten(Node n)
    {
        if (n == null)
            return null;

        boolean hasChild = (n.child != null);
        boolean hasNext = (n.next != null);
        if (hasChild)
        {
            Node end = recurseFlatten(n.child);
            n.child.prev = n;
            end.next = n.next;
            n.next = n.child;
            n.child = null;

            if (end.next != null)
            {
                end.next.prev = end;
                return recurseFlatten(end.next);
            }
            else return end;
        }
        else if (hasNext)
            return recurseFlatten(n.next);
        else
            return n;
    }*/

}
