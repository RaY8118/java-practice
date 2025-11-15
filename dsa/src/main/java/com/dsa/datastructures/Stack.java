package com.dsa.datastructures;

import java.util.Arrays;

public class Stack {

    private final int[] stack;
    private int top;
    private final int capacity;

    public Stack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack is overflow");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

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
