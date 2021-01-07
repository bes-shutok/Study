class MyLinkedList2 {

    MyLinkedListNode head;

    private int maxIndex;

    private class MyLinkedListNode {
        MyLinkedListNode next, prev;
        int val;

        MyLinkedListNode(int val) {
            this.val = val;
        }
    }


    /**
     * Initialize your data structure here.
     */
    MyLinkedList2() {
        head = null;
        maxIndex = -1;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (maxIndex < index || index < 0) return -1;
        MyLinkedListNode target = findAtIndex(index);
        return target.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyLinkedListNode newOne = new MyLinkedListNode(val);
        if (head != null) {
            newOne.next = head;
            newOne.next.prev = newOne;
        }
        head = newOne;
        maxIndex++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (maxIndex == -1) {
            addAtHead(val);
            return;
        }
        MyLinkedListNode target = findAtIndex(maxIndex);
        MyLinkedListNode newOne = new MyLinkedListNode(val);
        newOne.prev = target;
        if (target != null) {
            target.next = newOne;
        }
        maxIndex++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
     * not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (maxIndex < index -1 || index < 0) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (maxIndex == index - 1) {
            addAtTail(val);
            return;
        }
        MyLinkedListNode target = findAtIndex(index);
        MyLinkedListNode newOne = new MyLinkedListNode(val);
        newOne.prev = target.prev;
        target.prev = newOne;
        newOne.next = target;
        newOne.prev.next = newOne;
        maxIndex++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (maxIndex < index || index < 0) return;
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            maxIndex--;
            return;
        }
        MyLinkedListNode target = findAtIndex(index);
        MyLinkedListNode prevOne = target.prev;
        prevOne.next = target.next;
        if (target.next != null) {
            prevOne.next.prev = prevOne;
        }
        maxIndex--;
    }

    private MyLinkedListNode findAtIndex(int index) {
        if (maxIndex < index || index < 0) return null;
        MyLinkedListNode target = head;
        while (index > 0) {
            target = target.next;
            index--;
        }
        return target;
    }

    public static void main(String[] args) {
        MyLinkedList2 obj = new MyLinkedList2();
        System.out.println(obj.get(1));
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));

        obj = new MyLinkedList2();
        obj.addAtHead(1);
        obj.deleteAtIndex(0);

        obj = new MyLinkedList2();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtIndex(3, 0);
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        System.out.println(obj.get(4));
        obj.addAtHead(4);
        obj.addAtIndex(5,0);
        obj.addAtHead(6);

        obj = new MyLinkedList2();
        obj.addAtIndex(0, 10);
        obj.addAtIndex(0, 20);
        obj.addAtIndex(1, 30);
        System.out.println(obj.get(0));

        obj = new MyLinkedList2();
        obj.addAtHead(7);
        obj.addAtTail(0);
        obj.deleteAtIndex(1);
        obj.addAtTail(5);
        obj.addAtIndex(1, 1);
        obj.addAtIndex(2, 6);
        obj.deleteAtIndex(2);
        obj.deleteAtIndex(1);
        obj.addAtTail(7);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
