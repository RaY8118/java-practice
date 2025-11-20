package com.dsa.datastructures;

import java.util.Arrays;

public class Queue {

    private final int[] queue;
    private int front;
    private int rear;
    private final int capacity;

    public Queue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = value;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int size() {
        return rear - front + 1;
    }

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
