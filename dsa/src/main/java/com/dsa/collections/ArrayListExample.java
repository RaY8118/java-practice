package com.dsa.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates the basic functionalities and characteristics of
 * `java.util.ArrayList`.
 * `ArrayList` is a resizable array implementation of the `List` interface.
 * It is part of the Java Collections Framework.
 */
public class ArrayListExample {

    /*
     * Key Characteristics of ArrayList:
     * - Ordered: Yes (maintains insertion order)
     * - Allows duplicates: Yes
     * - Allows nulls: Yes
     * - Thread-safe: No (not synchronized; for thread-safe operations, consider
     * `Collections.synchronizedList` or
     * `java.util.concurrent.CopyOnWriteArrayList`)
     * - Underlying data structure: Dynamic array
     * - Access time: O(1) on average for `get` and `set` operations (random access)
     * - Insertion/Deletion time: O(n) on average for `add(index, element)` and
     * `remove(index)` as elements need to be shifted. O(1) for `add` at the end.
     */
    public static void main(String[] args) {
        // 1. Initialization: Creating an ArrayList of Strings
        // The `List` interface is used for polymorphism, allowing easy switching to
        // other List implementations like LinkedList.
        List<String> fruits = new ArrayList<>();

        System.out.println("--- Initial State ---");
        System.out.println("Is list empty? " + fruits.isEmpty()); // Check if the list is empty
        System.out.println("Current size: " + fruits.size()); // Get the current number of elements

        // 2. Adding Elements:
        // `add(E element)`: Appends the specified element to the end of this list.
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Banana"); // ArrayList allows duplicate elements

        System.out.println("--- After adding initial elements ---");
        System.out.println("List after adding: " + fruits); // Prints the list content
        System.out.println("Current size: " + fruits.size());

        // `add(int index, E element)`: Inserts the specified element at the specified
        // position in this list.
        // Elements currently at that position and any subsequent elements are shifted
        // to the right.
        fruits.add(1, "Mango"); // Insert "Mango" at index 1

        System.out.println("--- After inserting at index 1 ---");
        System.out.println("List after insertion: " + fruits);
        System.out.println("Current size: " + fruits.size());

        // 3. Accessing Elements:
        // `get(int index)`: Returns the element at the specified position in this list.
        // Indexing is 0-based.
        System.out.println("--- Accessing elements ---");
        System.out.println("Element at index 0: " + fruits.get(0)); // Should be "Apple"
        System.out.println("Element at index 1: " + fruits.get(1)); // Should be "Mango"

        // 4. Modifying Elements:
        // `set(int index, E element)`: Replaces the element at the specified position
        // in this list with the specified element.
        System.out.println("--- Modifying elements ---");
        fruits.set(0, "Grapes"); // Replace "Apple" at index 0 with "Grapes"
        System.out.println("List after modification: " + fruits);

        // 5. Removing Elements:
        // `remove(int index)`: Removes the element at the specified position in this
        // list.
        // Subsequent elements are shifted to the left.
        System.out.println("--- Removing elements ---");
        fruits.remove(2); // Remove element at index 2 (which is "Cherry" after "Grapes" and "Mango")
        System.out.println("List after removing by index (2): " + fruits);

        // `remove(Object o)`: Removes the first occurrence of the specified element
        // from this list, if it is present.
        fruits.remove("Banana"); // Removes the first "Banana"
        System.out.println("List after removing by object ('Banana'): " + fruits);

        // 6. Checking for Presence:
        // `contains(Object o)`: Returns true if this list contains the specified
        // element.
        System.out.println("--- Checking for presence ---");
        System.out.println("Does list contain 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Does list contain 'Apple'? " + fruits.contains("Apple")); // "Apple" was replaced by
                                                                                      // "Grapes"

        // 7. Size of the List:
        // `size()`: Returns the number of elements in this list.
        System.out.println("--- List size ---");
        System.out.println("Current size of the list: " + fruits.size());

        // 8. Iterating through the List:
        System.out.println("--- Iterating through the list (Enhanced for-loop) ---");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // 9. Sorting the List:
        // `Collections.sort(List<T> list)`: Sorts the specified list into ascending
        // order, according to the natural ordering of its elements.
        // For custom sorting, a `Comparator` can be provided.
        System.out.println("--- Sorting the list ---");
        Collections.sort(fruits);
        System.out.println("Sorted list: " + fruits);

        // 10. Clearing the List:
        // `clear()`: Removes all of the elements from this list. The list will be empty
        // after this call returns.
        System.out.println("--- Clearing the list ---");
        fruits.clear();
        System.out.println("List after clearing: " + fruits);
        System.out.println("Is list empty after clearing? " + fruits.isEmpty());
        System.out.println("Current size after clearing: " + fruits.size());
    }
}
