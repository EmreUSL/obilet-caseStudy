# Selenium Automation Template

![Java](https://img.shields.io/badge/Java-21-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![Build](https://img.shields.io/badge/Build-Maven-blue)
![Status](https://img.shields.io/badge/Status-In%20Progress-yellow)

A scalable and modular Selenium automation framework template built with Java.  
The project is designed to evolve step by step, starting from a robust and thread-safe driver management layer.

---

## 🚗 Driver Management

This framework provides a **centralized and thread-safe WebDriver management solution**.  
The main goal is to make driver handling **reusable, maintainable, and CI/CD friendly** while keeping test classes clean and focused on test logic only.

---

## 🧵 Thread-Safe Execution

WebDriver instances are managed using **ThreadLocal**, enabling safe parallel test execution.

Each test thread:
- Gets its **own isolated WebDriver instance**
- Avoids shared state and race conditions
- Can run independently without interfering with other tests

This design makes the framework **ready for parallel execution and future Selenium Grid integration**.

---

## 🌐 Browser Selection with Enums

Browser selection is handled using a **type-safe enum** instead of raw strings.

Benefits:
- Prevents invalid browser values at runtime
- Enables fail-fast behavior
- Makes browser support easier to extend
- Improves overall code readability and safety

---

## ⚙️ WebDriver Binary Management

WebDriver binaries are managed automatically using **Bonigarcia WebDriverManager**.

This approach:
- Eliminates manual driver setup
- Automatically resolves compatible driver versions
- Works seamlessly across different operating systems
- Is fully compatible with CI/CD pipelines

---

## 🏗 Architecture Overview

```text
┌───────────────┐   ┌───────────────┐   ┌──────────────────────┐
│ Test Classes  │──▶│   BaseTest    │──▶│    DriverManager     │
│ (Scenarios)   │   │ @Before/After │   │ ThreadLocal<WebDriver│
└───────────────┘   └───────────────┘   └───────────-│─────────┘
                                                     │
                                  ┌──────────────────┼──────────────────┐
                                  ▼                  ▼                  ▼
                         ┌──────────────┐    ┌──────────────┐   ┌──────────────┐
                         │ ChromeDriver │    │ FirefoxDriver│   │  EdgeDriver  │
                         └──────────────┘    └──────────────┘   └──────────────┘
                                  │                  │                  │
                                  ▼                  ▼                  ▼
                                       ┌────────────────────────────┐
                                       │     WebDriverManager       │
                                       │ (Driver Binary Management) │
                                       └────────────────────────────┘

```
---

## ⚙️ Configuration Management

This framework uses a layered and type-safe configuration system to keep environment-specific values out of test code and support scalable, CI/CD-friendly execution.

```text
📂 Structure
src/main/java
 └── config
     ├── ConfigReader.java
     ├── ConfigKeys.java
     └── ConfigurationManager.java

src/test/resources
 └── config
     └── config.properties
```

## 🧩 config.properties

```text
browser=chrome
baseUrl=https://example.com
headless=false
```

All environment-related values are managed from a single place.

## 📖 ConfigReader

Loads config.properties once at startup and provides raw values.
Fails fast if the file or a key is missing.

## 🗝 ConfigKeys

Defines all allowed configuration keys using enums to avoid magic strings and typos.

## 🧠 ConfigurationManager

Acts as a single entry point for accessing configuration values across the framework.
Handles type conversion (enum, boolean) and validation.

```text
BrowserType browser = ConfigurationManager.getBrowser();
String baseUrl = ConfigurationManager.getBaseUrl();
boolean headless = ConfigurationManager.isHeadless();
```

## 🔄 Configuration Flow
```text
config.properties → ConfigReader → ConfigurationManager → Framework Components
```

## ✅ Benefits

- No hard-coded values in tests

- Type-safe and centralized configuration

- Easy environment and browser switching

- CI/CD ready

---


## 🔹 UIActions & WaitActions Layers

The framework introduces two dedicated layers to manage UI synchronization and user interactions in a clean, consistent, and maintainable way.

### 🔸 WaitActions

WaitActions is responsible for handling all explicit wait operations within the framework.
It removes the need for hard-coded waits and ensures that elements are in the correct state before any interaction occurs.

### Responsibilities

- Handle explicit waits using By locators

- Provide reusable wait methods (visibility, clickability, presence)

- Centralize synchronization logic to avoid duplication

- Improve test stability in dynamic and asynchronous UI environments

All wait logic is managed internally by the framework.
Tests and Page Object classes never handle waits directly.

## 🔸 UIActions

UIActions is the main interaction layer built on top of WaitActions.
It encapsulates all Selenium UI operations and applies retry and fallback mechanisms to reduce flaky test behavior.

### Key Features

- Centralized UI interaction methods (click, type, scroll, hover, etc.)

- Built-in retry mechanism for unstable UI actions

- JavaScript click fallback for edge-case scenarios

- Clear separation between test logic and WebDriver usage

- Fully compatible with parallel execution and CI/CD pipelines

Example Usage
```text
UIActions.click(loginButton);
UIActions.type(usernameInput, "testuser");
UIActions.type(passwordInput, "password");
UIActions.click(loginSubmitButton);
```

Page Object classes are responsible only for defining locators and business flows.
Direct WebDriver usage is restricted to core framework layers.

---

## ✅ Assertion & Verification Layer

This framework includes a dedicated assertion and verification layer to keep
test cases clean, readable, and focused on business expectations instead of
technical assertion details.

Assertions are centralized to improve maintainability, reporting quality,
and parallel execution safety.

---

### 🔹 AssertActions (Hard Assertions)

`AssertActions` provides hard assertions for critical validations.
When a hard assertion fails, the test execution stops immediately.

Typical use cases:
- Mandatory validations
- Preconditions
- Critical business rules

Example usage:

```java
AssertActions.assertTrue(
    UIActions.isDisplayed(LoginPage.ERROR_MESSAGE),
    "Error message should be visible"
);
```

### 🔹 VerifyActions (Soft Assertions)

`VerifyActions` is built on top of TestNG `SoftAssert` and allows multiple
validations within a single test without stopping execution immediately.

#### Key Features
- Multiple assertions per test
- Thread-safe implementation using `ThreadLocal`
- Suitable for parallel test execution
- Aggregated failure reporting

#### Example Usage
```java
VerifyActions.verifyEquals(
    UIActions.getText(LoginPage.ERROR_MESSAGE),
    "Invalid credentials",
    "Error message text mismatch"
);
```

### 🔹 Soft Assertion Lifecycle

All soft assertions are automatically validated at the end of each test
through the `BaseTest` lifecycle.

```java
@AfterMethod
public void tearDown() {
    VerifyActions.assertAll();
    DriverManager.quitDriver();
}
```
#### This ensures
- No silent assertion failures
- Clear and aggregated assertion reports
- Proper WebDriver cleanup per test

---

### 🔹 Design Benefits
- Clean separation between test logic and assertion logic
- Improved test readability and maintainability
- Parallel execution safe
- Ready for future integrations such as screenshots on failure and Allure reporting

---

## 📊 Allure Reporting

This framework is integrated with Allure Report to provide rich, readable, and structured test execution reports.
Allure enables detailed visibility into:
- Test execution steps
- Pass / fail status
- Assertion failures
- Retry behavior

Parallel execution results
- The reporting setup is fully compatible with CI/CD pipelines.

### 🔹 Allure Step Usage

The framework uses dynamic steps via io.qameta.allure.Allure.step()
instead of annotation-based @Step usage.
This approach provides:
- Flexible and readable step definitions
- Dynamic step names with runtime values
- Cleaner test and framework code
- Better control over reporting structure


Example Usage
```java
Allure.step("Navigate to login page", () -> {
    DriverManager.getDriver().get(ConfigurationManager.getBaseUrl());
});

Allure.step("Enter username", () -> {
    UIActions.type(LoginPage.USERNAME_INPUT, "testuser");
});

Allure.step("Enter password", () -> {
    UIActions.type(LoginPage.PASSWORD_INPUT, "password");
});

Allure.step("Click login button", () -> {
    UIActions.click(LoginPage.LOGIN_BUTTON);
});
```

Each step appears as a separate and clearly defined action in the Allure report,
making test execution easy to follow.

### ▶️ Viewing Allure Report

After test execution, Allure results are generated under the allure-results directory.

To open the report locally, run the following command in terminal:
```java
allure serve allure-results
```


This command:
- Starts a temporary local web server
- Automatically opens the Allure report in the browser
- Requires no manual HTML generation

### 🧩 Allure Design Principles

- Allure logic is decoupled from test logic
- Steps can be added at test, page, or framework layer
- Fully compatible with parallel execution
- CI/CD ready (Jenkins, GitHub Actions, GitLab CI)

### ✅ Allure Benefits

- Human-readable and professional test reports
- Improved debugging through step-level visibility
- Clear execution flow for technical and non-technical users
- Extensible for future enhancements such as:
- Screenshot on failure
- Environment details
- Test metadata (Epic, Feature, Story)



