
Absolutely. Below is a curated set of **practice questions** similar to the two types you’ve worked on:

✅ **Type 1:** Object-oriented design with methods operating on arrays of objects
✅ **Type 2:** String, loop, and condition-based logic

---

## 📝 **Practice Set for Your Java Exam**

### 🔷 **Problem 1 – Mobile Class and Price Calculation**

Create a class `Mobile` with:

* `mobileName` (String)
* `brand` (String)
* `price` (int)
* `is5GEnabled` (boolean)

Write:

1. A method `findAveragePriceByBrand(Mobile[] mobiles, String brand)` to return average price of mobiles from the given brand. If no mobiles with the brand exist, return 0.
2. A method `getMostExpensive5GEnabledMobile(Mobile[] mobiles)` to return the `Mobile` object with highest price among 5G-enabled mobiles. Return null if none found.
3. A method `countMobilesByBrand(Mobile[] mobiles, String brand)` to return the number of mobiles for a given brand. If no mobiles with the brand exist, return 0.

---

### 🔷 **Problem 2 – String Vowel Consonant Count**

Write a program that reads a string and:

* Counts number of vowels
* Counts number of consonants
* A method `reverseString(String inputString)` to return the reversed string.

Print both counts. If there are no vowels or no consonants, print an appropriate message.

---

### 🔷 **Problem 3 – Book Class with Sorting**

Create a `Book` class with:

* `bookName` (String)
* `author` (String)
* `price` (int)

Write:

1. A method `getBooksSortedByPrice(Book[] books)` that returns an array of books sorted by their price in ascending order.
2. A method `findBookByAuthor(Book[] books, String author)` that returns an array of books by a specific author. Return an empty array if no books by the author are found.

---

### 🔷 **Problem 4 – Palindrome Word Count**

Read a sentence (string). Find and print the number of words in it that are palindromes (same forwards and backwards). If no palindromic words are found, print “No Palindrome Found”.

Add a method `getLongestPalindromeWord(String sentence)` that returns the longest palindrome word in the sentence. If no palindrome words are found, return null.

---

### 🔷 **Problem 5 – Employee Bonus Calculation**

Create `Employee` class with:

* `empName` (String)
* `salary` (int)
* `yearsOfExperience` (int)

Write:

1. A method `calculateBonus(Employee[] employees)` that increases salary by:

   * 20% if experience > 5 years
   * 10% otherwise

Return an array of updated Employee objects.
2. A method `getEmployeesByExperience(Employee[] employees, int minExperience)` that returns an array of employees with experience greater than or equal to `minExperience`. Return an empty array if no such employees are found.

---

### 🔷 **Problem 6 – Uppercase Character Count**

Write a program that reads a string and counts number of uppercase characters. If none are found, print “No uppercase characters present”.

Add a method `replaceUppercaseWithLowercase(String inputString)` that returns the string with all uppercase characters replaced by their lowercase equivalents.

---

### 🔷 **Problem 7 – Car Class: Lowest and Highest Price**

Create `Car` class with:

* `modelName` (String)
* `brand` (String)
* `price` (int)

Write:

1. A method to return the `Car` object with **lowest price**.
2. A method to return the `Car` object with **highest price**.
3. A method `filterCarsByBrand(Car[] cars, String brand)` that returns an array of cars for a given brand. Return an empty array if no cars for the brand are found.

If no cars exist, return null.

---

### 🔷 **Problem 8 – String: Word Length Filter**

Read a string and print words with length greater than 5 characters. If no such words exist, print “No words with length > 5 found”.

Add a method `countWordsWithLength(String inputString, int length)` that returns the count of words with a specific length.

---

## ✅ **Recommended Practice Strategy**

* Solve **at least 2-3 per day**.
* Implement full class and methods as in your syllabus.
* Test with **multiple inputs** to strengthen your logic confidence.
* If needed, I can **review your solutions line by line** for corrections and best practices before your exam.

---

Let me know which problem you want to attempt first today and I’ll guide you step by step to solve and understand it thoroughly.

---

### 🔷 **Problem 9 – Product Class and Inventory Management**

Create a `Product` class with:

* `productId` (String)
* `productName` (String)
* `category` (String)
* `price` (double)
* `stockQuantity` (int)

Write:

1. A method `findProductsByCategory(Product[] products, String category)` to return an array of `Product` objects belonging to the given category. Return an empty array if no products are found.
2. A method `calculateTotalInventoryValue(Product[] products)` to return the total monetary value of all products in the inventory (sum of price * stockQuantity for all products).
3. A method `getLowStockProducts(Product[] products, int threshold)` to return an array of `Product` objects whose `stockQuantity` is below the given `threshold`. Return an empty array if no such products are found.

---

### 🔷 **Problem 10 – String Anagram Checker**

Write a program that takes two strings as input and determines if they are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another, using all the original letters exactly once. The comparison should be case-insensitive and ignore non-alphabetic characters.

Return `true` if they are anagrams, `false` otherwise.

---
