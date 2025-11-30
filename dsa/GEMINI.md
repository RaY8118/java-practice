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

## Commit Message Conventions

To maintain a clear and consistent commit history, please adhere to the following guidelines for commit messages:

*   **Format:** Use the [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) specification.
    *   `type`: mandatory, e.g., `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`.
    *   `scope` (optional): context of the commit, e.g., `(arrays)`, `(sorting)`, `(docs)`.
    *   `description`: concise summary of the change.
*   **Examples:**
    *   `feat(arrays): Add KidsWithCandies solution`
    *   `fix(sorting): Correct BubbleSort edge case`
    *   `docs: Update Javadoc conventions`
*   **Content:**
    *   Start with an imperative mood: "Add", "Fix", "Change", not "Added", "Fixed", "Changed".
    *   Keep the subject line (first line) short (50-72 characters).
    *   Provide a more detailed body if necessary, explaining *why* the change was made and *what* its impact is.

## Javadoc Conventions

To maintain consistency across the project, all new classes and methods should be documented using Javadoc. The following is an example of a well-documented class:

```java
package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Implements the Bubble Sort algorithm to sort an array of integers.
 * This class provides a method for sorting and a main method to demonstrate its usage.
 */
public class BubbleSort {
    /**
     * Main method to demonstrate the Bubble Sort algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * The algorithm repeatedly steps through the list, compares adjacent elements
     * and swaps them if they are in the wrong order.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n^2)
     *   Average Case: O(n^2)
     *   Best Case: O(n)
     * Space Complexity: O(1)
     *
     * @param arr The array of integers to be sorted.
     */
    static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
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
    *   For all algorithms and data structures, include the time and space complexity in the method's Javadoc.
    *   Use the `@param` tag to describe each parameter.
    *   Use the `@return` tag to describe the return value.
    *   Use the `@throws` tag to describe any exceptions that the method might throw.

*   **General:**
    *   Write clear and concise descriptions.
    *   Keep the Javadoc up-to-date with any changes to the code.
