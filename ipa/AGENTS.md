# Agent Guidelines for IPA Java Project

## Build/Test Commands
- **Compile**: `mvn compile`
- **Run all tests**: `mvn test`
- **Run single test class**: `mvn test -Dtest=ClassNameTest`
- **Run single test method**: `mvn test -Dtest=ClassNameTest#testMethodName`
- **Clean and compile**: `mvn clean compile`

## Code Style Guidelines

### Project Structure
- **Package naming**: `com.ray8118.ipa.(dsa|oops)`
- **Source directory**: `src/main/java/`
- **Test directory**: `src/test/java/`
- **DSA problems**: `com.ray8118.ipa.dsa` package
- **OOP problems**: `com.ray8118.ipa.oops` package

### Naming Conventions
- **Classes**: PascalCase (e.g., `Anagram`, `Student`)
- **Methods**: camelCase (e.g., `isAnagram`, `getTopper`)
- **Fields**: camelCase (e.g., `rollNumber`, `department`)
- **Test methods**: descriptive with pattern `testMethodName_description` (e.g., `testIsAnagram_basicAnagram`)

### Code Patterns
- **Input validation**: Always check for null inputs and return appropriate defaults
- **Edge cases**: Handle empty arrays, null values, and boundary conditions
- **Return values**: Use empty arrays for "not found", null for single object not found
- **Array operations**: Prefer array-based solutions over collections
- **Static methods**: Use static methods for utility operations on arrays
- **Test imports**: `import static org.junit.jupiter.api.Assertions.assertEquals;`

### Error Handling
- **Null checks**: Validate inputs before processing
- **Early returns**: Return early for invalid inputs (e.g., null arrays, empty strings)
- **Graceful degradation**: Return sensible defaults rather than throwing exceptions

### Documentation
- **File headers**: Include problem description/scenario as comments at file top
- **Method comments**: No inline comments unless complex logic requires explanation
- **Test naming**: Self-documenting test method names describing expected behavior

### Testing
- **Framework**: JUnit Jupiter
- **Assertion style**: `assertEquals(expected, actual)`
- **Test coverage**: Comprehensive edge cases including nulls, empties, boundaries
- **Test organization**: One test class per implementation class