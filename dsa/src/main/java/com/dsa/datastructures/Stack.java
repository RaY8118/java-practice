package com.dsa.datastructures;

import java.util.Arrays;

public class Stack {

    private final int[] stack;
    private int top;
    private final int capacity;

    /**
     * Initializes a new Stack with a given capacity.
     * <p>
     * Time Complexity: O(size) for array initialization.
     * Space Complexity: O(size) for the internal array.
     *
     * @param size The maximum capacity of the stack.
     */
    public Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     * Pushes an element onto the top of the stack.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param value The element to be pushed onto the stack.
     */
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack is overflow");
        }
        stack[++top] = value;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The element at the top of the stack, or -1 if the stack is empty.
     */
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The element at the top of the stack, or -1 if the stack is empty.
     */
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    /**
     * Checks if the stack is empty.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the number of elements currently in the stack.
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @return The number of elements in the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Displays the elements of the stack, starting from the top.
     * If the stack is empty, it prints a message.
     * <p>
     * Time Complexity: O(n), where n is the current number of elements in the stack.
     * Space Complexity: O(1)
     */
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    @Override
    public String toString() {
        return "Stack [stack=" + Arrays.toString(Arrays.copyOfRange(stack, 0, top + 1)) + ", top=" + top + ", capacity="
                + capacity + "]";
    }

    public static void main(String[] args) {
        // Create stack
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Read values from stack
        System.out.println(stack.peek());

        // Delete value from stack
        System.out.println(stack.toString());
        stack.pop();
        System.out.println(stack.toString());
    }
}
