# Viewing Test Reports - Step by Step Guide

## Report Location

After running tests with `mvn test` or `mvn clean test`, the HTML report is automatically generated and saved in:

```
test-reports/html/test-report.html
```

The XML raw data files are saved in:

```
test-reports/xml/
```

---

## How to Open the Report

### Windows

1. Open File Explorer
2. Navigate to the project folder: `pengolahan-nilai-mahasiswa`
3. Open the `test-reports` folder
4. Open the `html` folder
5. Double-click on `test-report.html` file
6. The report will open in your default web browser

Alternative: Right-click on `test-report.html` and select "Open with" then choose your preferred browser.

### Mac

1. Open Finder
2. Navigate to the project folder: `pengolahan-nilai-mahasiswa`
3. Open the `test-reports` folder
4. Open the `html` folder
5. Double-click on `test-report.html` file
6. The report will open in your default web browser

### Linux

1. Open File Manager
2. Navigate to the project folder: `pengolahan-nilai-mahasiswa`
3. Open the `test-reports` folder
4. Open the `html` folder
5. Right-click on `test-report.html` and select "Open With"
6. Choose your preferred web browser

Alternative: From terminal, run:
```bash
firefox test-reports/html/test-report.html
```
or
```bash
chromium test-reports/html/test-report.html
```

---

## Understanding the Report Structure

The HTML report contains the following sections:

### 1. Test Summary Section

Located at the top of the report, showing:
- Total number of tests executed
- Number of tests passed
- Number of tests failed
- Number of tests skipped
- Overall success percentage
- Execution time in milliseconds

### 2. Test Class Breakdown

Each test class is listed with:
- Class name (e.g., ValidationModule.IsValidTest)
- Number of tests in that class
- Number passed, failed, and skipped
- Time taken to execute

### 3. Individual Test Method Details

Clicking on a test class expands to show:
- Individual test method names
- Pass or Fail status for each method
- Failure messages with detailed error information
- Stack traces for debugging

### 4. Error Details Section

If tests fail, the report shows:
- Error message describing what went wrong
- Expected value vs Actual value comparison
- Line number where assertion failed
- Stack trace for debugging

---

## Interpreting Test Results

### PASSED Tests

Indicated by:
- Green checkmark or green color highlighting
- Status shows "Pass" or "Passed"
- No error message displayed
- Test executed successfully

### FAILED Tests

Indicated by:
- Red color highlighting
- Status shows "Fail" or "Failed"
- Error message visible below test name
- Shows expected value and actual value
- Stack trace provided for debugging

### SKIPPED Tests

Indicated by:
- Yellow or gray color highlighting
- Status shows "Skip" or "Skipped"
- Reason for skipping displayed
- Test was not executed

---

## Reading Test Failure Messages

When a test fails, the report shows:

Example failure message format:
```
Test Name: testGetNilaiAkhir
Status: FAILED
Error Message: Expected 70.0 but was 66.0
Location: NilaiMahasiswa/GetNilaiAkhirTest.java:28
```

To fix the failure:
1. Note the test name and line number
2. Read the expected vs actual values
3. Check the test data in Params file
4. Verify the calculation logic
5. Update the test data or implementation as needed

---

## Searching and Filtering

### Using Browser Search (Ctrl+F or Cmd+F)

1. Press Ctrl+F (Windows/Linux) or Cmd+F (Mac)
2. Type test name or keyword
3. Browser highlights matching results
4. Press Enter to navigate through results

### Common Search Terms

- Test class name (e.g., "ValidationModule")
- Test method name (e.g., "testIsValid")
- Failure keyword (e.g., "FAILED")
- Specific value (e.g., "60.0")

---

## Report Not Displaying Correctly

### Problem: Report file is empty or blank

Solution:
1. Close the current report window
2. Run tests again: mvn clean test
3. Wait for completion
4. Open the report file again

### Problem: Cannot find test-report.html

Solution:
1. Verify you ran tests with: mvn test
2. Check if test-reports folder exists in project root
3. If missing, run: mvn clean test
4. Ensure write permissions on test-reports folder

### Problem: Report shows old test results

Solution:
1. Delete the test-reports folder
2. Run: mvn clean test
3. Open the newly generated report

---

## Sharing Test Reports

### Sending Report to Others

1. Compress the test-reports folder to ZIP
2. Send the ZIP file via email or file sharing service
3. Recipient can extract and open test-report.html

### Storing Reports for Historical Comparison

1. Copy test-reports folder after each test run
2. Rename with date: test-reports-2024-01-15
3. Store in version control or backup location
4. Compare reports from different runs

### Publishing to Web Server

1. Upload test-reports/html/ to web server
2. Share the URL with team
3. Team can view reports from any browser

---

## Command Line Commands

### Run tests and generate report
```bash
mvn clean test
```

### Run specific test class
```bash
mvn test -Dtest=ValidationModule.IsValidTest
```

### View console output during tests
```bash
mvn test -X
```

### Skip test execution (only open existing report)
```bash
cd test-reports/html
open test-report.html
```

---

## Quick Reference

Report location: `test-reports/html/test-report.html`
Raw XML data: `test-reports/xml/TEST-*.xml`
Run command: `mvn clean test`
Expected duration: 2-5 seconds

If report is stale or incorrect, always run `mvn clean test` to regenerate.

---

## Troubleshooting Checklist

Have you:
1. Ran the test command? `mvn clean test`
2. Waited for completion (no errors in terminal)?
3. Checked the correct folder path?
4. Used the correct report file name?
5. Tried opening in different browser?
6. Cleared browser cache if needed?
7. Verified file permissions are readable?

If still having issues:
1. Check pom.xml configuration
2. Verify test files are compiled
3. Check console output for error messages
4. Review TEST-GUIDE.md for additional help

---

Last Updated: 2024
For more information, see TEST-GUIDE.md