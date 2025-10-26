
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

### 🔷 **Problem 11 – Laptop Class: Performance Analysis**

Create a `Laptop` class with:

* `model` (String)
* `brand` (String)
* `price` (int)
* `ram` (int) - in GB
* `storage` (int) - in GB

Write:

1. A method `findLaptopsByRam(Laptop[] laptops, int minRam)` to return an array of laptops with RAM greater than or equal to `minRam`. Return an empty array if none found.
2. A method `getAveragePriceByBrand(Laptop[] laptops, String brand)` to return the average price of laptops from the given brand. Return 0 if no laptops from the brand exist.
3. A method `getLaptopWithMaxStorage(Laptop[] laptops)` to return the laptop with the highest storage capacity. Return null if no laptops exist.

---

### 🔷 **Problem 12 – String Digit and Letter Counter**

Write a program that reads a string and:

* Counts the number of digits (0-9)
* Counts the number of letters (a-z, A-Z)
* A method `removeNonAlphanumeric(String inputString)` that returns the string with all non-alphanumeric characters removed.

Print both counts. If there are no digits or no letters, print an appropriate message.

---

### 🔷 **Problem 13 – Movie Class: Rating and Genre Analysis**

Create a `Movie` class with:

* `title` (String)
* `genre` (String)
* `rating` (double)
* `duration` (int) - in minutes

Write:

1. A method `findMoviesByGenre(Movie[] movies, String genre)` to return an array of movies belonging to the given genre. Return an empty array if none found.
2. A method `getHighestRatedMovie(Movie[] movies)` to return the movie with the highest rating. Return null if no movies exist.
3. A method `calculateAverageDurationByGenre(Movie[] movies, String genre)` to return the average duration of movies in the given genre. Return 0 if no movies in the genre exist.

---

### 🔷 **Problem 14 – String Substring Frequency**

Read a string and a substring. Count how many times the substring appears in the string (case-sensitive). If the substring is not found, print "Substring not found".

Add a method `findAllSubstringPositions(String inputString, String substring)` that returns an array of integers representing the starting positions of all occurrences of the substring.

---

### 🔷 **Problem 15 – Student Grade Calculator**

Create a `Student` class with:

* `name` (String)
* `rollNumber` (int)
* `marks` (int)
* `grade` (String)

Write:

1. A method `calculateGrade(Student[] students)` that assigns grades based on marks:
   * A: 90-100
   * B: 80-89
   * C: 70-79
   * D: 60-69
   * F: below 60

   Return an array of updated Student objects.
2. A method `getStudentsByGrade(Student[] students, String grade)` to return an array of students with the specified grade. Return an empty array if none found.
3. A method `getTopScorer(Student[] students)` to return the student with the highest marks. Return null if no students exist.

---

### 🔷 **Problem 16 – String Case Converter**

Write a program that reads a string and:

* Converts all uppercase letters to lowercase
* Converts all lowercase letters to uppercase
* A method `toggleCase(String inputString)` that swaps the case of each letter in the string.

Print the converted string.

---

### 🔷 **Problem 17 – Restaurant Class: Menu Analysis**

Create a `Dish` class with:

* `dishName` (String)
* `cuisine` (String)
* `price` (double)
* `isVegetarian` (boolean)

Write:

1. A method `findDishesByCuisine(Dish[] dishes, String cuisine)` to return an array of dishes from the given cuisine. Return an empty array if none found.
2. A method `getAveragePriceByCuisine(Dish[] dishes, String cuisine)` to return the average price of dishes from the given cuisine. Return 0 if no dishes from the cuisine exist.
3. A method `getVegetarianDishes(Dish[] dishes)` to return an array of all vegetarian dishes. Return an empty array if none found.

---

### 🔷 **Problem 18 – String Word Reversal**

Read a sentence and reverse the order of words while keeping the words themselves intact. For example, "Hello World Java" becomes "Java World Hello".

Add a method `reverseWordsInSentence(String sentence)` that returns the sentence with words reversed.

---

### 🔷 **Problem 19 – Bank Account Class: Transaction Management**

Create a `BankAccount` class with:

* `accountNumber` (String)
* `holderName` (String)
* `balance` (double)
* `accountType` (String) - "Savings" or "Current"

Write:

1. A method `deposit(BankAccount[] accounts, String accountNumber, double amount)` that adds the amount to the specified account's balance. Return the updated accounts array.
2. A method `withdraw(BankAccount[] accounts, String accountNumber, double amount)` that subtracts the amount from the specified account's balance (if sufficient funds). Return the updated accounts array.
3. A method `getAccountsByType(BankAccount[] accounts, String type)` to return an array of accounts of the specified type. Return an empty array if none found.

---

### 🔷 **Problem 20 – String Character Frequency**

Write a program that reads a string and finds the most frequent character (case-insensitive). If there are multiple characters with the same highest frequency, return any one of them. If the string is empty, return a space character.

Add a method `getCharacterFrequency(String inputString, char character)` that returns the count of a specific character in the string (case-insensitive).

---

### 🔷 **Problem 21 – Advanced Employee Management System**

Create an `Employee` class with:

* `empId` (String)
* `name` (String)
* `department` (String)
* `salary` (double)
* `joiningDate` (String) - format: "YYYY-MM-DD"
* `performanceRating` (int) - 1 to 5

Write:

1. A method `getEmployeesByPerformanceAndDepartment(Employee[] employees, String department, int minRating)` that returns employees from the specified department with performance rating >= minRating, sorted by salary descending. Return empty array if none found.

2. A method `calculateDepartmentWiseBonus(Employee[] employees)` that gives bonus based on:
   - Department "IT": 15% bonus if rating >= 4, 10% otherwise
   - Department "HR": 12% bonus if rating >= 3, 8% otherwise
   - Department "Finance": 18% bonus if rating >= 4, 12% otherwise
   - Other departments: 10% bonus if rating >= 3, 5% otherwise
   Return updated employees array.

3. A method `findSeniorEmployees(Employee[] employees, String currentDate)` that returns employees who have been with the company for more than 5 years (calculate from joiningDate to currentDate). Return empty array if none found.

---

### 🔷 **Problem 22 – Complex String Pattern Analysis**

Write a program that analyzes a string for multiple patterns:

* Find all words that start and end with the same letter (case-insensitive)
* Count words containing at least 3 vowels
* Find the longest word that contains no repeated characters
* A method `analyzeStringPatterns(String inputString)` that returns a custom object containing all the above analysis results.

Print detailed results. Handle edge cases like empty strings, single-character words, and strings with no alphabetic characters.

---

### 🔷 **Problem 23 – University Course Management**

Create a `Course` class with:

* `courseId` (String)
* `courseName` (String)
* `instructor` (String)
* `credits` (int)
* `maxCapacity` (int)
* `enrolledStudents` (int)
* `department` (String)

Write:

1. A method `getAvailableCourses(Course[] courses)` that returns courses where enrolledStudents < maxCapacity, sorted by available slots descending. Return empty array if none found.

2. A method `getCoursesByInstructorWorkload(Course[] courses, String instructor, int maxCredits)` that returns courses taught by the instructor where total credits across all their courses <= maxCredits. Return empty array if none found.

3. A method `optimizeCourseAssignment(Course[] courses)` that redistributes students from over-capacity courses to under-capacity courses in the same department, ensuring no course exceeds maxCapacity. Return the optimized courses array.

---

### 🔷 **Problem 24 – Advanced String Compression and Decompression**

Implement a string compression algorithm that:

* Replaces consecutive repeated characters with the character followed by the count (e.g., "aaabbb" becomes "a3b3")
* For single characters, just keep the character (no count)
* A method `compressString(String inputString)` that returns the compressed version.

Also implement the reverse:

* A method `decompressString(String compressedString)` that converts back to the original string.

Handle edge cases like empty strings, strings with no consecutive repeats, and invalid compressed formats.

---

### 🔷 **Problem 25 – E-commerce Order Processing System**

Create an `Order` class with:

* `orderId` (String)
* `customerId` (String)
* `items` (String[]) - array of item names
* `quantities` (int[]) - corresponding quantities
* `prices` (double[]) - corresponding unit prices
* `orderDate` (String) - format: "YYYY-MM-DD"
* `status` (String) - "Pending", "Processing", "Shipped", "Delivered"

Write:

1. A method `calculateOrderTotal(Order[] orders, String orderId)` that returns the total value of a specific order. Return 0 if order not found.

2. A method `getOrdersByStatusAndDateRange(Order[] orders, String status, String startDate, String endDate)` that returns orders with the specified status within the date range (inclusive). Return empty array if none found.

3. A method `getTopSellingItems(Order[] orders, int topN)` that analyzes all delivered orders and returns the top N most sold items by total quantity. Return array of item names.

---

### 🔷 **Problem 26 – Complex Number Pattern Recognition**

Write a program that identifies various number patterns in a string:

* Find all valid phone numbers (formats: XXX-XXX-XXXX, (XXX) XXX-XXXX, XXX.XXX.XXXX)
* Extract all valid email addresses (basic validation)
* Find sequences of consecutive numbers (like "123", "456")
* A method `extractPatterns(String inputString)` that returns a structured result with all found patterns categorized.

Handle overlapping patterns and validate formats properly.

---

### 🔷 **Problem 27 – Hospital Patient Management**

Create a `Patient` class with:

* `patientId` (String)
* `name` (String)
* `age` (int)
* `diagnosis` (String)
* `admissionDate` (String) - format: "YYYY-MM-DD"
* `dischargeDate` (String) - can be null if still admitted
* `treatmentCost` (double)

Write:

1. A method `getCurrentlyAdmittedPatients(Patient[] patients)` that returns patients where dischargeDate is null. Return empty array if none found.

2. A method `calculateAverageTreatmentCostByDiagnosis(Patient[] patients, String diagnosis)` that returns average cost for patients with the specified diagnosis who have been discharged. Return 0 if no discharged patients with that diagnosis.

3. A method `findPatientsByAgeGroupAndDiagnosis(Patient[] patients, int minAge, int maxAge, String diagnosis)` that returns patients within the age range with the specified diagnosis, sorted by admission date. Return empty array if none found.

4. A method `generateHospitalReport(Patient[] patients)` that returns a report object containing:
   - Total patients
   - Currently admitted count
   - Average age of all patients
   - Most common diagnosis
   - Total treatment cost for discharged patients

---

### 🔷 **Problem 28 – Advanced Text Processing**

Implement a text processing system that:

* Removes all HTML tags from a string (basic implementation)
* Converts markdown-style formatting to plain text (*bold* becomes bold, _italic_ becomes italic, etc.)
* Normalizes whitespace (multiple spaces become single, trim leading/trailing)
* A method `processText(String inputText)` that applies all transformations and returns the cleaned text.

Also implement:

* A method `extractSentences(String text)` that splits text into sentences (handling ., !, ?)
* A method `countSyllablesInText(String text)` that estimates syllable count using basic rules

---

### 🔷 **Problem 29 – Stock Portfolio Management**

Create a `Stock` class with:

* `symbol` (String)
* `companyName` (String)
* `currentPrice` (double)
* `purchasePrice` (double)
* `shares` (int)
* `purchaseDate` (String) - format: "YYYY-MM-DD"

Write:

1. A method `calculatePortfolioValue(Stock[] stocks)` that returns total current value of all stocks.

2. A method `getProfitableStocks(Stock[] stocks, double minProfitPercent)` that returns stocks where (currentPrice - purchasePrice) / purchasePrice * 100 >= minProfitPercent. Return empty array if none found.

3. A method `rebalancePortfolio(Stock[] stocks, double[] targetAllocations)` that adjusts share quantities to match target percentage allocations based on current values. Return the rebalanced stocks array.

4. A method `getStockPerformanceReport(Stock[] stocks)` that returns a report with:
   - Best performing stock (highest % gain)
   - Worst performing stock (lowest % gain)
   - Total portfolio gain/loss
   - Diversification analysis (how many different stocks)

---

### 🔷 **Problem 30 – Advanced Algorithmic String Problems**

Implement these challenging string algorithms:

1. **Longest Common Substring**: Find the longest string that is a substring of two given strings.

2. **String Permutation Check**: Determine if one string is a permutation of another, but allowing for character frequency differences within a tolerance.

3. **Run Length Encoding with Optimization**: Compress a string using RLE, but optimize by not encoding single characters unless they appear in sequences that would benefit from encoding.

4. **Anagram Groups**: Group all anagrams together from an array of strings, returning groups as arrays.

5. **String Chain Reaction**: Given an array of strings, find the longest chain where each string is one character different from the previous string.

Each method should handle edge cases and provide efficient implementations.

---
