public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;

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
        newNode.prev = curr;
    }

    void delete(int data) {
        if (head == null)
            return;

        Node curr = head;

        if (curr.data == data) {
            head = curr.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (curr.next != null) {
            if (curr.data == data) {
                curr.prev.next = curr.next;
            }
            if (curr.next != null) {
                curr.next.prev = curr.prev;
            }
            return;
        }
        curr = curr.next;
    }

    void displayForward() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    void displayBackward() {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        System.out.println("Display Forward");
        list.displayForward();
        System.out.println("Display Backward");
        list.displayBackward();
        System.out.println("Delete 3");
        list.delete(3);
        list.displayForward();
        list.displayBackward();
    }
}
