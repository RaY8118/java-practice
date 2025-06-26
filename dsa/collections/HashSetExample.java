import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class demonstrates the basic functionalities of a HashSet in Java.
 * A HashSet is an unordered collection that does not allow duplicate elements.
 * It uses a hash table for storage, which means it provides constant-time performance
 * for the basic operations (add, remove, contains, and size), assuming the hash function
 * disperses the elements properly among the buckets.
 */
public class HashSetExample {

  public static void main(String[] args) {
    // 1. HashSet Initialization
    // Create a new HashSet to store String elements.
    // HashSet does not maintain any insertion order.
    Set<String> hashSet = new HashSet<>();

    // 2. Adding Elements to HashSet
    // Elements are added using the add() method.
    // Duplicate elements (like "Apple" added twice) are ignored.
    // HashSet allows one null element.
    System.out.println("--- Adding Elements ---");
    hashSet.add("Apple");
    hashSet.add("Banana");
    hashSet.add("Cherry");
    hashSet.add("Apple"); // This is a duplicate and will not be added
    hashSet.add(null);    // Adding a null element

    // 3. Printing the HashSet
    // The order of elements in the output is not guaranteed due to the nature of HashSet.
    System.out.println("Set contents after additions: " + hashSet);
    System.out.println("Size after additions: " + hashSet.size()); // Size will be 4 (Apple, Banana, Cherry, null)

    // 4. Checking for Element Existence
    // The contains() method checks if an element is present in the set.
    System.out.println("--- Checking Element Existence ---");
    System.out.println("Contains 'Banana'? " + hashSet.contains("Banana"));
    System.out.println("Contains 'Grape'? " + hashSet.contains("Grape"));
    System.out.println("Contains null? " + hashSet.contains(null));

    // 5. Removing Elements
    // Elements can be removed using the remove() method.
    System.out.println("--- Removing Elements ---");
    hashSet.remove("Banana");
    System.out.println("Set contents after removing 'Banana': " + hashSet);
    System.out.println("Size after removal: " + hashSet.size());

    // 6. Iterating Through HashSet
    // You can iterate over the elements of a HashSet using an enhanced for-loop.
    // Again, the order of iteration is not guaranteed.
    System.out.println("--- Iterating Through Set ---");
    for (String fruit : hashSet) {
      System.out.println("Fruit: " + fruit);
    }

    // 7. Getting the Size of the HashSet
    // The size() method returns the number of elements in the set.
    System.out.println("--- Getting Set Size ---");
    System.out.println("Current Size of the set: " + hashSet.size());

    // 8. Converting HashSet to List
    // A HashSet can be converted to an ArrayList (or any other List implementation)
    // if you need an ordered collection or need to access elements by index.
    System.out.println("--- Converting to List ---");
    List<String> fruitList = new ArrayList<>(hashSet);
    System.out.println("Converted to ArrayList: " + fruitList);

    // 9. Clearing the HashSet
    // The clear() method removes all elements from the set.
    System.out.println("--- Clearing the Set ---");
    hashSet.clear();
    System.out.println("Set contents after clearing: " + hashSet);
    System.out.println("Is the set empty? " + hashSet.isEmpty());

    // 10. Understanding hashCode (for demonstration, not directly related to HashSet operations)
    // HashSet uses the hashCode() method of objects to determine where to store them.
    // This line shows the hash code for the string "Apple".
    // Objects that are equal (according to their equals() method) must have the same hash code.
    System.out.println("--- HashCode Demonstration ---");
    System.out.println("Hash code for 'Apple': " + "Apple".hashCode());
    System.out.println("Hash code for 'Banana': " + "Banana".hashCode());
  }
}
