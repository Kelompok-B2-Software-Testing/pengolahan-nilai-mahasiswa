@echo off
REM Test Runner and Report Viewer Script
REM Purpose: Run tests and automatically open HTML report
REM Author: Test Team
REM Date: 2024

setlocal enabledelayedexpansion

echo.
echo ========================================
echo Test Execution and Report Viewer
echo ========================================
echo.

REM Check if pom.xml exists
if not exist "pom.xml" (
    echo Error: pom.xml not found. Make sure you run this script from the project root directory.
    pause
    exit /b 1
)

REM Step 1: Clean and run tests
echo Step 1: Building and running tests...
echo.
mvn clean test

REM Check if tests passed or failed
if %ERRORLEVEL% NEQ 0 (
    echo.
    echo Tests completed with errors or failures.
    echo Opening report anyway...
) else (
    echo.
    echo All tests passed successfully!
)

REM Step 2: Wait a moment for report generation
echo.
echo Waiting for report generation...
timeout /t 2 /nobreak

REM Step 3: Check if report exists
if exist "test-reports\html\test-report.html" (
    echo.
    echo Report found! Opening in default browser...
    echo.
    start test-reports\html\test-report.html
    echo Report opened successfully.
) else (
    echo.
    echo Warning: Report file not found at test-reports\html\test-report.html
    echo Please check if tests ran successfully.
)

REM Step 4: Show report location
echo.
echo ========================================
echo Report Location:
echo test-reports\html\test-report.html
echo.
echo XML Data Location:
echo test-reports\xml\
echo ========================================
echo.

pause
