/*
* Given a linked list, determine if it has a cycle in it.
* To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
* in the linked list where the tail connects to. If pos == -1, then there is no cycle in the linked list.
* 
* */

import java.util.HashSet;
import java.util.Set;

public class LinkedListHasCycle {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     *
     * If the preliminary tail is length T and the cycle is length C (so in your picture, T=3, C=6), we can label the tail nodes (starting at the one farthest from the cycle) as −T,−(T−1),...,−1 and the cycle nodes 0,1,2,...,C−1
     *
     * (with the cycle node numbering oriented in the direction of travel).
     *
     * We may use the division algorithm to write T=kC+r where 0≤r<C
     *
     * After T
     * clicks the tortoise is at node 0 and the hare is at node r (since hare has gone 2T steps, of which the first T were in the tail, leaving T steps in the cycle, and T≡r(modC)
     *
     * ).
     *
     * Assuming r≠0
     * , after an additional C−r clicks, the tortoise is at node C−r; and the hare is at node congruent (modC) to r+2(C−r)=2C−r≡C−r(modC). Hence both critters are at node C−r. [In the r=0 case, you can check that the animals meet at the node 0
     *
     * .]
     *
     * The distance from the start at this meeting time is thus T+C−r=(kC+r)+C−r=(k+1)C
     * , a multiple of the cycle length, as desired. We can further note, this occurrence is at the first multiple of the cycle length that is greater than or equal to the tail length.
     *
     * https://math.stackexchange.com/questions/913499/proof-of-floyd-cycle-chasing-tortoise-and-hare
     * https://umairsaeed.com/posts/2011-06-23-finding-the-start-of-a-loop-in-a-circular-linked-list/
     * https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
     * https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle
     * https://medium.com/@andrewjoliver/the-software-bakers-dozen-linkedlists-3e97fd14ad12
     * https://javarevisited.blogspot.com/2013/05/find-if-linked-list-contains-loops-cycle-cyclic-circular-check.html
     * https://www.netsurfingzone.com/datastructures/linkedlist/circularlinkedlist/loop-detection-in-a-linked-list/
     * https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work-How-does-moving-the-tortoise-to-the-beginning-of-the-linked-list-while-keeping-the-hare-at-the-meeting-place-followed-by-moving-both-one-step-at-a-time-make-them-meet-at-starting-point-of-the-cycle?share=1
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     *
     * Runtime: 4 ms
     * Memory Usage: 40.1 MB
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode start = head;
        Set<ListNode> seen = new HashSet<>();
        Set<ListNode> cycle = new HashSet<>();
        while (head != null && !seen.contains(head)) {
            if (!seen.contains(head)) {
                seen.add(head);
                head = head.next;
            }
        }
        if (head == null) return null;
        while (!cycle.contains(head)) {
            cycle.add(head);
            head = head.next;
        }
        while (!cycle.contains(start)) {
            start = start.next;
        }
        return start;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head, meetingPoint = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetingPoint = fast;
                break;
            }
        }
        if (meetingPoint == null) return null;
        slow = head;
        while (slow != meetingPoint) {
            slow = slow.next;
            meetingPoint = meetingPoint.next;
        }
        return meetingPoint;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;
        LinkedListHasCycle t = new LinkedListHasCycle();
        System.out.println(t.hasCycle(one));
        if (!t.hasCycle(one)) {
            System.out.println("no cycle");
        }  else System.out.println(t.detectCycle1(one).val);

        if (!t.hasCycle(one)) {
            System.out.println("no cycle");
        }  else System.out.println(t.detectCycle2(one).val);
    }
}
