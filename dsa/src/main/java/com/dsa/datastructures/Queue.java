package com.dsa.datastructures;

import java.util.Arrays;

public class Queue {

    private final int[] queue;
    private int front;
    private int rear;
    private final int capacity;

    /**
     * Initializes a new Queue with a given capacity.
     * <p>
     * Time Complexity: O(size) for array initialization.
     * Space Complexity: O(size) for the internal array.
     *
     * @param size The maximum capacity of the queue.
     */
    public Queue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    /**
     * Adds an element to the rear of the queue.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param value The element to be added to the queue.
     */
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = value;
    }

    /**
     * Removes and returns the element from the front of the queue.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The element at the front of the queue, or -1 if the queue is empty.
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The element at the front of the queue, or -1 if the queue is empty.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    /**
     * Checks if the queue is empty.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front > rear;
    }

    /**
     * Checks if the queue is full.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return rear == capacity - 1;
    }

    /**
     * Returns the number of elements currently in the queue.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return rear - front + 1;
    }

    /**
     * Displays the elements of the queue from front to rear.
     * <p>
     * Time Complexity: O(n), where n is the current number of elements in the queue.
     * Space Complexity: O(1)
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    @Override
    public String toString() {
        return "Queue [queue=" + Arrays.toString(Arrays.copyOfRange(queue, front, rear)) + ", front=" + front
                + ", rear=" + rear
                + ", capacity="
                + capacity + "]";
    }

    public static void main(String[] args) {
        // Create queue
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // Read values from queue
        System.out.println(queue.peek());

        // Delete values from queue
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
    }

}
