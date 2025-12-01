package com.dsa.collections;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class demonstrates the basic functionalities of a LinkedList in Java.
 * A LinkedList is a part of the Java Collections Framework and implements both
 * the List and Deque interfaces. It is a doubly-linked list implementation.
 * <p>
 * Key Characteristics of LinkedList:
 * <ul>
 *     <li>Interface: List, Deque (meaning it can be used as a list or a double-ended queue)</li>
 *     <li>Ordered: Yes (maintains insertion order of elements)</li>
 *     <li>Allows duplicates: Yes (can store multiple identical elements)</li>
 *     <li>Allows nulls: Yes (can store null values)</li>
 *     <li>Thread-safe: No (not synchronized; must synchronize manually if accessed by multiple threads concurrently)</li>
 *     <li>Structure: Doubly linked list (each node holds a reference to the next and previous node)</li>
 * </ul>
 * <p>
 * Time Complexity for common operations:
 * <ul>
 *     <li>`add(E element)` (at end, `addLast`): O(1)</li>
 *     <li>`addFirst(E element)`: O(1)</li>
 *     <li>`add(int index, E element)`: O(n) (requires traversing to the `index`)</li>
 *     <li>`get(int index)`: O(n) (requires traversing to the `index`)</li>
 *     <li>`getFirst()` / `getLast()`: O(1)</li>
 *     <li>`set(int index, E element)`: O(n) (requires traversing to the `index`)</li>
 *     <li>`remove(Object o)`: O(n) (requires traversing to find the element)</li>
 *     <li>`remove(int index)`: O(n) (requires traversing to the `index`)</li>
 *     <li>`removeFirst()` / `removeLast()`: O(1)</li>
 *     <li>`contains(Object o)`: O(n) (linear search)</li>
 *     <li>`size()` / `isEmpty()`: O(1)</li>
 *     <li>Iteration: O(n), where n is the number of elements.</li>
 * </ul>
 * <p>
 * Space Complexity:
 * <ul>
 *     <li>O(n) for storing n elements.</li>
 * </ul>
 */
public class LinkedListExample {
  public static void main(String[] args) {
    // 1. LinkedList Initialization
    // Creates an empty LinkedList to store String elements.
    LinkedList<String> linkedList = new LinkedList<>();
    System.out.println("Initial LinkedList: " + linkedList);

    // 2. Adding Elements
    // Elements are added to the end of the list by default.
    linkedList.add("Red");
    linkedList.add("Green");
    linkedList.add("Blue");
    System.out.println("After adding Red, Green, Blue: " + linkedList);

    // Add at a specific index: Inserts "Yellow" at index 1.
    // Elements from index 1 onwards are shifted to the right.
    linkedList.add(1, "Yellow");
    System.out.println("After adding Yellow at index 1: " + linkedList);

    // Add to front and end:
    // addFirst() adds an element to the beginning of the list.
    linkedList.addFirst("Start");
    // addLast() adds an element to the end of the list (same as add()).
    linkedList.addLast("End");
    System.out.println("After adding Start (first) and End (last): " + linkedList);

    // 3. Accessing Elements
    // getFirst(): Retrieves the first element.
    System.out.println("First element: " + linkedList.getFirst());
    // getLast(): Retrieves the last element.
    System.out.println("Last element: " + linkedList.getLast());
    // get(index): Retrieves the element at the specified index.
    System.out.println("Element at index 2: " + linkedList.get(2));

    // 4. Modifying Elements
    // set(index, element): Replaces the element at the specified index with a new
    // element.
    linkedList.set(2, "Purple");
    System.out.println("After setting element at index 2 to Purple: " + linkedList);

    // 5. Removing Elements
    // remove(object): Removes the first occurrence of the specified element.
    linkedList.remove("Green");
    System.out.println("After removing Green: " + linkedList);
    // removeFirst(): Removes and returns the first element of the list.
    linkedList.removeFirst();
    System.out.println("After removing first element: " + linkedList);
    // removeLast(): Removes and returns the last element of the list.
    linkedList.removeLast();
    System.out.println("After removing last element: " + linkedList);
    // remove(index): Removes the element at the specified index.
    linkedList.remove(2); // Note: Index 2 might be different after previous removals
    System.out.println("After removing element at index 2: " + linkedList);

    // 6. Checking for Element Existence
    // contains(object): Returns true if the list contains the specified element.
    System.out.println("Contains Blue? " + linkedList.contains("Blue"));

    // 7. Getting the Size
    // size(): Returns the number of elements in the list.
    System.out.println("Current Size: " + linkedList.size());

    // 8. Iterating Through the LinkedList
    System.out.println("Iterating through the LinkedList (for-each loop):");
    for (String color : linkedList) {
      System.out.println("Color: " + color);
    }

    // Reverse iteration using descendingIterator:
    // descendingIterator() returns an iterator that traverses the list in reverse
    // order.
    Iterator<String> descItr = linkedList.descendingIterator();
    System.out.println("Iterating through the LinkedList in reverse order:");
    while (descItr.hasNext()) {
      System.out.println(descItr.next());
    }

    // 9. Clearing the LinkedList
    // clear(): Removes all elements from the list.
    linkedList.clear();
    System.out.println("After clearing the LinkedList: " + linkedList);
    // isEmpty(): Returns true if the list contains no elements.
    System.out.println("Is empty? " + linkedList.isEmpty());
  }
}
