package com.dsa.datastructures;

public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        /**
         * Constructs a new Node with the given data.
         * <p>
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         *
         * @param data The data to be stored in the node.
         */
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    /**
     * Inserts a new node with the given data at the end of the singly linked list.
     * <p>
     * Time Complexity: O(n) in the worst case, where n is the number of nodes in the list.
     * Space Complexity: O(1)
     *
     * @param data The data to be inserted.
     */
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    /**
     * Deletes the first occurrence of a node with the given data from the singly linked list.
     * <p>
     * Time Complexity: O(n) in the worst case, where n is the number of nodes in the list.
     * Space Complexity: O(1)
     *
     * @param data The data of the node to be deleted.
     */
    void delete(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    /**
     * Displays the elements of the singly linked list.
     * <p>
     * Time Complexity: O(n), where n is the number of nodes in the list.
     * Space Complexity: O(1)
     */
    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();

        list.delete(20);
        list.display();
    }

}
