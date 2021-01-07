/*
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
 *
 * */

import java.util.HashMap;

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
public class LinkedListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            this.val = x;
            this.next = null;
            this.random = null;
        }

        Node(int x, Node next) {
            this.val = x;
            this.next = next;
            this.random = null;
        }

        Node(int x, Node next, Node random) {
            this.val = x;
            this.next = next;
            this.random = random;
        }

        @Override
        public String toString() {
            return "Linked list with Random Pointer  #" + this.getClass().getName() + " with \n" +
                    "value = " + this.val + "\n" +
                    "random (val) = " + ((this.random == null) ? "null\n" : this.random.val + "\n") +
                    "next = " + ((this.next == null) ? "null\n" : "\n" + this.next.toString());
        }
    }

    /*    Runtime: 0 ms
    Memory Usage: 38.4 MB*/
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = new Node(cur.val,tmp,null);
            cur = tmp;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node copyList = head.next;
        while (cur != null) {
            Node copy = cur.next;
            Node next = cur.next.next;
            cur.next = copy.next;
            if (next != null) copy.next = next.next;
            cur = next;
        }
        return copyList;
    }


/*    Runtime: 0 ms
    Memory Usage: 38.6 MB*/
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node cur = head, newHead, tmp;
        while (cur != null) {
            cur.next = new Node(cur.val,cur.next,null);
            cur = cur.next.next;
        }

        cur = head;
        newHead = head.next;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        while (cur != null) {
            tmp = cur.next.next;
            if (tmp != null) cur.next.next = tmp.next;
            cur.next = tmp;
            cur = tmp;
        }
        return newHead;
    }

/*
    Time complexity ~ n
    Space complexity ~ 3n ( + 1 for map itself)
    Runtime: 0 ms
    Memory Usage: 39.1 MB
    */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        HashMap<Node,Node> oldToNew = new HashMap<>();
        Node cur = head, newHead, newCur, randomCur, curNext;

        // Head of the copied list
        newHead = new Node(cur.val);
        oldToNew.put(cur, newHead);
        if (cur.random != null) {
            if (!oldToNew.containsKey(cur.random)) {
                randomCur = new Node(cur.random.val);
                oldToNew.put(cur.random, randomCur);
            } else randomCur = oldToNew.get(cur.random);
            newHead.random = randomCur;
        }
        newCur = newHead;

        // Copy for cur.next node
        while (cur.next != null) {
            if (!oldToNew.containsKey(cur.next)) {
                curNext = new Node(cur.next.val);
                oldToNew.put(cur.next, curNext);
            } else curNext = oldToNew.get(cur.next);
            newCur.next = curNext;
            if (cur.next.random != null) {
                if (!oldToNew.containsKey(cur.next.random)) {
                    randomCur = new Node(cur.next.random.val);
                    oldToNew.put(cur.next.random, randomCur);
                } else randomCur = oldToNew.get(cur.next.random);
                newCur.next.random = randomCur;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListWithRandomPointer t = new LinkedListWithRandomPointer();

        Node one = t.new Node(1);
        Node two = t.new Node(2);
        Node three = t.new Node(3);
        Node four = t.new Node(4);
        Node five = t.new Node(5);
        Node six = t.new Node(6);
        Node seven = t.new Node(7);
        Node eight = t.new Node(8);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;

        two.random = five;
        six.random = eight;
        testNodes(one);
        Node oneCopy = t.copyRandomList(one);
        testNodes(oneCopy, one, null);
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
}
