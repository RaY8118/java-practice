package com.dsa.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * This class demonstrates the basic functionalities of a HashMap in Java.
 * A HashMap stores key-value pairs. It is part of the Java Collections Framework.
 * <p>
 * Key characteristics:
 * <ul>
 *     <li>It does not maintain insertion order.</li>
 *     <li>It allows one null key and multiple null values.</li>
 *     <li>It is not synchronized (not thread-safe).</li>
 *     <li>Underlying data structure: Hash table.</li>
 * </ul>
 * <p>
 * Time Complexity for common operations (assuming good hash function and minimal collisions):
 * <ul>
 *     <li>`put(K key, V value)`: Average O(1), Worst Case O(n) (due to hash collisions or resizing)</li>
 *     <li>`get(Object key)`: Average O(1), Worst Case O(n) (due to hash collisions)</li>
 *     <li>`remove(Object key)`: Average O(1), Worst Case O(n) (due to hash collisions)</li>
 *     <li>`containsKey(Object key)`: Average O(1), Worst Case O(n)</li>
 *     <li>`containsValue(Object value)`: O(n) (requires iteration through all values)</li>
 *     <li>`size()` / `isEmpty()`: O(1)</li>
 * </ul>
 * <p>
 * Space Complexity:
 * <ul>
 *     <li>O(n) for storing n entries.</li>
 * </ul>
 */
public class HashMapExample {

  public static void main(String[] args) {
    // 1. HashMap Initialization
    // Declaring a Map interface type and initializing with HashMap.
    // The keys are of type String and values are of type Integer.
    Map<String, Integer> scores = new HashMap<>();

    // 2. Adding Entries to HashMap (put method)
    // The put(key, value) method is used to insert an entry into the HashMap.
    scores.put("Alice", 85);
    scores.put("Bob", 90);
    scores.put("Charlie", 80);
    System.out.println("Initial HashMap: " + scores);

    // 3. Handling Duplicate Keys
    // If a key already exists, the old value is replaced with the new value.
    scores.put("Alice", 95);
    System.out.println("HashMap after updating Alice's score: " + scores);

    // 4. Null Keys and Values
    // HashMap allows one null key and multiple null values.
    scores.put(null, 50); // Adding a null key
    scores.put("David", null); // Adding a null value
    System.out.println("HashMap with null key and value: " + scores);

    // 5. Retrieving Values (get method)
    // The get(key) method returns the value associated with the specified key.
    // If the key is not found, it returns null.
    System.out.println("Alice's score: " + scores.get("Alice"));
    System.out.println("Score with null key: " + scores.get(null));
    System.out.println("Score for 'Eve' (non-existent key): " + scores.get("Eve")); // Demonstrates null return for
                                                                                    // non-existent key

    // 6. Checking for Key/Value Existence (containsKey and containsValue methods)
    // containsKey(key) returns true if the map contains a mapping for the specified
    // key.
    // containsValue(value) returns true if the map maps one or more keys to the
    // specified value.
    System.out.println("Contains key 'Bob'? " + scores.containsKey("Bob"));
    System.out.println("Contains value 80? " + scores.containsValue(80));
    System.out.println("Contains key 'Frank'? " + scores.containsKey("Frank"));

    // 7. Removing Entries (remove method)
    // The remove(key) method removes the mapping for the specified key from this
    // map if present.
    scores.remove("Charlie");
    System.out.println("HashMap after removing Charlie: " + scores);
    scores.remove("NonExistent"); // Removing a non-existent key has no effect
    System.out.println("HashMap after trying to remove non-existent key: " + scores);

    // 8. Getting the Size of HashMap (size method)
    // The size() method returns the number of key-value mappings in this map.
    System.out.println("Current size of HashMap: " + scores.size());

    // 9. Iterating Through HashMap
    System.out.println("--- Iterating Through HashMap ---");

    // 9.1. Iterate using keySet()
    // keySet() returns a Set view of the keys contained in this map.
    System.out.println("Keys in HashMap:");
    for (String key : scores.keySet()) {
      System.out.println(key);
    }

    // 9.2. Iterate using values()
    // values() returns a Collection view of the values contained in this map.
    System.out.println("Values in HashMap:");
    for (Integer value : scores.values()) {
      System.out.println(value);
    }

    // 9.3. Iterate using entrySet() (Recommended for efficiency)
    // entrySet() returns a Set view of the mappings contained in this map.
    // Each element in the set is a Map.Entry object, which contains both the key
    // and the value.
    System.out.println("Entries in HashMap (Key -> Value):");
    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    // 10. Clearing the HashMap (clear method)
    // The clear() method removes all of the mappings from this map.
    scores.clear();
    System.out.println("HashMap after clearing all entries: " + scores);

    // 11. Checking if HashMap is Empty (isEmpty method)
    // The isEmpty() method returns true if this map contains no key-value mappings.
    System.out.println("Is HashMap empty? " + scores.isEmpty());

  }
}