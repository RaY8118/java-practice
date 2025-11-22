# Project Overview

This project is a Java-based repository focused on Data Structures and Algorithms (DSA). It serves as a practice ground and collection for various algorithms and data structures implementations. The project is organized into logical packages such as `algorithms` (further broken down into `arrays`, `miscellaneous`, `searching`, `sorting`, `stacks`, `strings`) and `datastructures` (e.g., `Array`, `DoublyLinkedList`, `Queue`, `SinglyLinkedList`, `Stack`). It utilizes Maven for dependency management and build automation.

## Building and Running

This project uses Apache Maven for its build lifecycle.

### Prerequisites

*   Java Development Kit (JDK) 21 or newer
*   Apache Maven

### Build the Project

To compile the Java source code and package it into a JAR file, run the following command from the project root:

```bash
mvn clean install
```

This will compile all classes and create a `dsa-1.0-SNAPSHOT.jar` in the `target/` directory.

### Run a Specific Class

You can run individual Java classes with a `main` method using the `exec-maven-plugin`. For example, to run the `FindEvenNums` class:

```bash
mvn exec:java -Dexec.mainClass="com.dsa.algorithms.arrays.FindEvenNums"
```

Replace `"com.dsa.algorithms.arrays.FindEvenNums"` with the fully qualified name of the class you wish to execute.

## Development Conventions

*   **Language:** Java 21.
*   **Build Tool:** Maven.
*   **Package Structure:** Code is organized under `com.dsa` with sub-packages reflecting the type of algorithm or data structure (e.g., `com.dsa.algorithms.arrays`, `com.dsa.datastructures`).
*   **Code Style:** Standard Java conventions are followed, including Javadoc comments for classes and methods, clear variable naming, and consistent formatting. See the "Javadoc Conventions" section for more details.
*   **IDE:** The presence of `.project`, `.classpath`, and `.settings/` suggests it might be developed using Eclipse, but it's a standard Maven project and should be compatible with any Java IDE.

## Javadoc Conventions

To maintain consistency across the project, all new classes and methods should be documented using Javadoc. The following is an example of a well-documented class:

```java
package com.dsa.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the "Kids with the Greatest Number of
 * Candies" problem on LeetCode.
 * <p>
 * LeetCode problem 1431:
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * <p>
 * It determines which kids will have the greatest number of candies if they are
 * given some extra candies.
 */
public class KidsWithCandies {

    /**
     * The main method to test the kidsWithCandies function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));

        int[] candies2 = { 4, 2, 1, 1, 2 };
        int extraCandies2 = 1;
        System.out.println(kidsWithCandies(candies2, extraCandies2));
    }

    /**
     * Determines which kids will have the greatest number of candies after
     * receiving extra candies.
     *
     * @param candies      An array of integers representing the number of candies
     *                     each kid has.
     * @param extraCandies The number of extra candies to be given to each kid.
     * @return A list of booleans, where each element at index i is true if the i-th
     *         kid will have the
     *         greatest number of candies after receiving extra candies, and false
     *         otherwise.
     */
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> boolArray = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies(candies)) {
                boolArray.add(true);
            } else {
                boolArray.add(false);
            }
        }
        return boolArray;
    }

    /**
     * Finds the maximum number of candies any kid has.
     *
     * @param candies An array of integers representing the number of candies each
     *                kid has.
     * @return The maximum number of candies.
     */
    private static int maxCandies(int[] candies) {
        int maxCandy = candies[0];
        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }

        return maxCandy;
    }
}
```

### Guidelines

*   **Class Javadoc:**
    *   The Javadoc for a class should provide a brief description of the class's purpose.
    *   If the class is a solution to a specific problem (e.g., from LeetCode), include the problem number and a link to the problem description.
    *   Use `<p>` tags to separate paragraphs for better readability.

*   **Method Javadoc:**
    *   The Javadoc for a method should describe what the method does.
    *   Use the `@param` tag to describe each parameter.
    *   Use the `@return` tag to describe the return value.
    *   Use the `@throws` tag to describe any exceptions that the method might throw.

*   **General:**
    *   Write clear and concise descriptions.
    *   Keep the Javadoc up-to-date with any changes to the code.
