package crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

class Node {

    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }

    public boolean hasCycle() {
        HashSet<Node> set = new HashSet<>();
        while (this.next != null) {
            set.add(this);
            if (set.contains(this)) {
                return true;
            }
            this.data = next.data;
            this.next = next.next;
        }
        return false;
    }
}

public class LinkedList {
    private Node head;

    public void append(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        }

        Node current = head;
        while(current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    // Linear Time - Finds if LinkedList is circular;
    private boolean hasCycle() {
        Node node = head;

        Set<Node> nodeSet = new HashSet<>();
        nodeSet.add(head);
        while(node != null) {
            if(nodeSet.contains(node)) {
                return true;
            }
            nodeSet.add(node);
            node = head.next;
        }
        return false;
    }
}
