# Test Execution and Report Guide

## Overview

This guide provides instructions for running tests and viewing test reports for the Pengolahan Nilai Mahasiswa project.

## Prerequisites

Before running tests, ensure you have:
- Java 11 or higher
- Maven 3.6.0 or higher
- Project built successfully

## Quick Start

### 1. Build Project

```bash
cd pengolahan-nilai-mahasiswa
mvn clean package -DskipTests
```

### 2. Run All Tests

```bash
mvn test
```

This command will:
- Execute all test classes
- Generate test reports in test-reports folder
- Display results in console

### 3. Run Specific Test Class

```bash
mvn test -Dtest=ValidationModule.IsValidTest
```

### 4. Run Specific Test Method

```bash
mvn test -Dtest=ValidationModule.IsValidTest#testIsValidWithValidValues
```

## Test Report Locations

After running tests, reports are saved in the following directories:

### XML Reports (Raw Data)
Location: test-reports/xml/
Contains machine-readable test results in XML format

### HTML Reports (Formatted View)
Location: test-reports/html/
Contains human-readable HTML formatted test reports

### Console Output (Terminal)
Displayed directly in terminal during test execution
Shows real-time test results

## Understanding Test Results

### Console Output Format

The console displays results in the following format:

```
[PASSED] Test case description
[FAILED] Test case description
         Error: Error message details
[SKIPPED] Test case description
```

### Test Summary Report

At the end of test execution, a summary is displayed:

```
================================================================================
TEST EXECUTION SUMMARY
================================================================================
Total Tests Run:    XX
Tests Passed:       XX [XX.XX%]
Tests Failed:       XX [XX.XX%]
Tests Skipped:      XX [XX.XX%]
--------------------------------------------------------------------------------
Execution Time:     XXXX ms
Status:             SUCCESS - All tests passed
Timestamp:          YYYY-MM-DD HH:MM:SS
================================================================================
```

## Test Structure

### Test Organization

Tests are organized by object class:

ValidationModule/
- ValidationModuleParams.java (test data)
- IsValidTest.java (test cases)

NilaiMahasiswa/
- NilaiMahasiswaParams.java (test data)
- GetNilaiAkhirTest.java
- GetTugasTest.java
- GetUtsTest.java
- GetUasTest.java

ServiceGrade/
- ServiceGradeParams.java (test data)
- GetGradeTest.java
- GetStatusTest.java

InputUtils/
- InputUtilsParams.java (test data)
- InputFloatTest.java

### Parameter Template Pattern

Each test object folder contains:
- *Params.java: Centralized test data (expected and actual values)
- Test*.java: Test cases that use data from Params files

This approach reduces redundancy and makes maintenance easier.

## Viewing Test Reports

### Option 1: View in Browser (HTML Report)

After running tests, open the HTML report:

Windows:
```bash
start test-reports/html/test-report.html
```

Linux/Mac:
```bash
open test-reports/html/test-report.html
```

Or navigate manually to: test-reports/html/test-report.html

### Option 2: Generate Maven Site Report

```bash
mvn site:site
```

Then open: target/site/index.html

### Option 3: View XML Reports

Raw XML reports are available at: test-reports/xml/

## Test Execution Scenarios

### Scenario 1: Full Test Suite

```bash
mvn clean test
```

Executes all tests in all classes and generates complete reports.

### Scenario 2: Test Single Module

ValidationModule tests only:
```bash
mvn test -Dtest=ValidationModule.*
```

### Scenario 3: Test with Verbose Output

```bash
mvn test -X
```

Provides detailed logging information.

### Scenario 4: Skip Tests (Build Only)

```bash
mvn clean package -DskipTests
```

### Scenario 5: Run Tests Multiple Times

```bash
mvn clean test && mvn test
```

First cleans and runs tests, then runs tests again to verify consistency.

## Test Coverage Details

### By Object Class

ValidationModule:
- Total test cases: 12+
- Coverage: isValid() method with valid and invalid inputs

NilaiMahasiswa:
- Total test cases: 35+
- Coverage: getNilaiAkhir(), getTugas(), getUts(), getUas() methods

ServiceGrade:
- Total test cases: 23+
- Coverage: getGrade() and getStatus() methods with boundary testing

InputUtils:
- Total test cases: 20+
- Coverage: inputFloat() method with valid, invalid, and retry scenarios

## Interpreting Test Results

### Pass Criteria

A test is considered PASSED when:
- The actual result matches the expected result
- No exceptions are thrown
- All assertions pass

### Failure Criteria

A test is considered FAILED when:
- The actual result does NOT match the expected result
- An unexpected exception is thrown
- An assertion fails

### Skip Criteria

A test is considered SKIPPED when:
- Marked with @Disabled annotation
- Prerequisites are not met
- Explicitly aborted

## Common Issues and Solutions

### Issue: Tests not found

Solution:
```bash
mvn clean test
```

Ensure test files follow naming convention: *Test.java

### Issue: Import errors

Solution:
- Rebuild project: mvn clean install
- Check pom.xml for missing dependencies
- Verify package declarations in test files

### Issue: Tests timeout

Solution:
- Check for infinite loops in test logic
- Verify mock input data in test parameters
- Increase timeout in test configuration

### Issue: Report not generated

Solution:
- Verify test-reports directory exists
- Check write permissions for test-reports folder
- Run: mvn test surefire-report:report

## Best Practices

1. Always clean before full test runs:
   ```bash
   mvn clean test
   ```

2. Review test reports after each execution

3. Fix failed tests immediately

4. Run tests before committing code changes

5. Keep test data in *Params.java files for maintainability

6. Use descriptive test case names for clarity

7. Review console output for detailed failure information

## Commands Reference

Run all tests:
```bash
mvn test
```

Run tests with clean:
```bash
mvn clean test
```

Run specific test class:
```bash
mvn test -Dtest=ClassName
```

Run specific test method:
```bash
mvn test -Dtest=ClassName#methodName
```

Generate HTML report:
```bash
mvn surefire-report:report
```

View test reports:
- HTML: test-reports/html/test-report.html
- XML: test-reports/xml/

Generate Maven site:
```bash
mvn site:site
```

## Troubleshooting

### Build fails during test phase

Check for:
1. Java version compatibility
2. Maven version compatibility
3. Missing dependencies in pom.xml
4. Compilation errors in test files

### Reports not accessible

Verify:
1. test-reports directory exists
2. Correct path to report files
3. File permissions are readable
4. Browser can access local files

### Inconsistent test results

Possible causes:
1. Test data pollution between test runs
2. Incorrect test isolation
3. External state affecting tests
4. Timing issues in async tests

Solution:
1. Run tests individually
2. Check for @BeforeEach and @AfterEach setup/cleanup
3. Verify parameter template data is correct

## Additional Resources

Test Parameter Templates:
- ValidationModule/ValidationModuleParams.java
- NilaiMahasiswa/NilaiMahasiswaParams.java
- ServiceGrade/ServiceGradeParams.java
- InputUtils/InputUtilsParams.java

Project Configuration:
- pom.xml: Maven build configuration
- src/test/resources/junit-platform.properties: JUnit configuration

Test Report Stylesheet:
- target/site/: Generated Maven site
- test-reports/: Custom report directory

## Support

For test-related issues:
1. Check this guide first
2. Review test output messages
3. Check test parameter data accuracy
4. Verify project structure and dependencies
5. Consult Maven documentation

---

Last Updated: 2024
Project: Pengolahan Nilai Mahasiswa
Version: 1.0.0-SNAPSHOT