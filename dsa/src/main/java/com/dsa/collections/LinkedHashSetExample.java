package com.dsa.collections;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // 1. Creating a LinkedHashSet
        // A LinkedHashSet is an ordered version of HashSet that maintains a
        // doubly-linked list
        // running through all of its entries. This linkage list defines the iteration
        // ordering,
        // which is the order in which elements were inserted into the set
        // (insertion-order).
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        System.out.println("1. Initial LinkedHashSet: " + linkedHashSet);

        // 2. Adding elements to the LinkedHashSet using add()
        // Elements are added in insertion order. Duplicate elements are not added.
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");
        linkedHashSet.add("Apple"); // This will not be added as it's a duplicate
        System.out.println("2. LinkedHashSet after adding elements: " + linkedHashSet);

        // 3. Checking if an element exists using contains()
        // Returns true if the set contains the specified element, false otherwise.
        System.out.println("3. Does LinkedHashSet contain 'Banana'? " + linkedHashSet.contains("Banana"));
        System.out.println("   Does LinkedHashSet contain 'Grape'? " + linkedHashSet.contains("Grape"));

        // 4. Removing an element using remove()
        // Removes the specified element from this set if it is present.
        linkedHashSet.remove("Banana");
        System.out.println("4. LinkedHashSet after removing 'Banana': " + linkedHashSet);

        // 5. Getting the size of the LinkedHashSet using size()
        // Returns the number of elements in this set.
        System.out.println("5. Size of LinkedHashSet: " + linkedHashSet.size());

        // 6. Iterating through the LinkedHashSet using an Iterator
        // Elements are iterated in insertion order.
        System.out.print("6. Iterating through LinkedHashSet: ");
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 7. Iterating through the LinkedHashSet using a for-each loop
        System.out.print("7. Iterating through LinkedHashSet (for-each): ");
        for (String element : linkedHashSet) {
            System.out.print(element + " ");
        }
        System.out.println();

        // 8. Checking if the LinkedHashSet is empty using isEmpty()
        // Returns true if this set contains no elements.
        System.out.println("8. Is LinkedHashSet empty? " + linkedHashSet.isEmpty());

        // 9. Clearing all elements from the LinkedHashSet using clear()
        // Removes all of the elements from this set. The set will be empty after this
        // call returns.
        linkedHashSet.clear();
        System.out.println("9. LinkedHashSet after clearing all elements: " + linkedHashSet);
        System.out.println("   Is LinkedHashSet empty after clear()? " + linkedHashSet.isEmpty());

        // 10. Adding all elements from another collection using addAll()
        LinkedHashSet<String> newLinkedHashSet = new LinkedHashSet<>();
        newLinkedHashSet.add("Mango");
        newLinkedHashSet.add("Pineapple");
        linkedHashSet.addAll(newLinkedHashSet);
        System.out.println("10. LinkedHashSet after adding all from another collection: " + linkedHashSet);

        // 11. Retaining only the elements that are contained in another collection
        // using retainAll()
        LinkedHashSet<String> commonElements = new LinkedHashSet<>();
        commonElements.add("Mango");
        commonElements.add("Grape");
        linkedHashSet.retainAll(commonElements);
        System.out
                .println("11. LinkedHashSet after retaining common elements with {'Mango', 'Grape'}: " + linkedHashSet);

        // 12. Removing all elements that are contained in another collection using
        // removeAll()
        linkedHashSet.add("Kiwi");
        linkedHashSet.add("Strawberry");
        System.out.println("    LinkedHashSet before removeAll: " + linkedHashSet);
        LinkedHashSet<String> elementsToRemove = new LinkedHashSet<>();
        elementsToRemove.add("Kiwi");
        linkedHashSet.removeAll(elementsToRemove);
        System.out.println("12. LinkedHashSet after removing {'Kiwi'}: " + linkedHashSet);

        // 13. Converting LinkedHashSet to an Array
        // Returns an array containing all of the elements in this set.
        String[] array = linkedHashSet.toArray(new String[0]);
        System.out.print("13. LinkedHashSet converted to Array: ");
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 14. Cloning a LinkedHashSet (shallow copy)
        // Creates a shallow copy of the LinkedHashSet instance.
        LinkedHashSet<String> clonedLinkedHashSet = (LinkedHashSet<String>) linkedHashSet.clone();
        System.out.println("14. Cloned LinkedHashSet: " + clonedLinkedHashSet);
        System.out
                .println("    Are original and cloned sets the same object? " + (linkedHashSet == clonedLinkedHashSet));
        System.out.println(
                "    Are original and cloned sets equal in content? " + linkedHashSet.equals(clonedLinkedHashSet));
    }
}
