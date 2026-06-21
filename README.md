# API Automation Framework with CI/CD using Rest Assured, TestNG & GitHub Actions

## Overview

This project is a robust API Automation Testing Framework built using Java, Rest Assured, TestNG, Maven, and GitHub Actions.

The framework automates validation of REST APIs, supports data-driven testing using JSON files and POJO classes, and is integrated with a complete CI/CD pipeline that automatically executes tests, generates reports, publishes results, sends email notifications, and posts execution summaries to Google Chat.

---

## Key Features

### API Automation

* GET Request Validation
* POST Request Validation
* PUT Request Validation
* DELETE Request Validation
* Status Code Verification
* Response Body Validation
* JSON Schema Validation
* Response Time Verification

### Data-Driven Testing

* Test data maintained in JSON files
* Dynamic request payload generation
* Jackson ObjectMapper integration
* Custom Data Provider implementation

### CI/CD Automation

* GitHub Actions Integration
* Automated test execution on code push
* Pull Request validation
* Test result extraction
* TestNG report generation
* GitHub Pages report publishing
* Google Chat notifications
* Automated email reporting

---

## Technology Stack

| Category        | Technology              |
| --------------- | ----------------------- |
| Language        | Java 17                 |
| API Automation  | Rest Assured            |
| Test Framework  | TestNG                  |
| Build Tool      | Maven                   |
| JSON Processing | Jackson                 |
| Reporting       | TestNG Reports          |
| CI/CD           | GitHub Actions          |
| Version Control | Git                     |
| IDE             | IntelliJ IDEA / Eclipse |

---

## Framework Architecture

```text
ApiAutomationCICD
│
├── .github
│   └── workflows
│       └── maven.yml
│
├── src
│   ├── main
│   │   └── java
│   │       └── com.videogamedb
│   │           ├── library
│   │           └── pojo
│   │
│   └── test
│       └── java
│           └── com.videogamedb.testcases
│
├── resources
│   ├── payload.json
│   ├── loginreqs.json
│   ├── registerreqres.json
│   └── other test data files
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## API Test Coverage

The framework currently validates:

### Video Game Database APIs

* Retrieve Video Game List
* Retrieve Single Video Game
* Create Video Game
* Update Video Game
* Delete Video Game

### ReqRes APIs

* Get Users
* Create User
* Register User
* Login User
* Unsuccessful Login Validation
* Unsuccessful Registration Validation
* Delayed Response Validation

---

## CI/CD Workflow

The project includes a fully automated GitHub Actions pipeline.

Pipeline Trigger:

* Push to Main Branch
* Pull Requests
* Manual Workflow Dispatch

Pipeline Steps:

1. Notify Google Chat on execution start
2. Checkout repository
3. Setup Java 17 environment
4. Execute Maven TestNG suite
5. Extract execution statistics
6. Upload test artifacts
7. Generate timestamped report folder
8. Publish reports to GitHub Pages
9. Send execution summary to Google Chat
10. Email execution report

---

## Automated Reporting

The framework automatically generates:

### TestNG Reports

* Passed Tests
* Failed Tests
* Skipped Tests
* Execution Summary

### GitHub Pages Reports

Each execution publishes a dedicated report folder with timestamp-based versioning.

### Google Chat Notifications

Execution notifications include:

* Repository Name
* Trigger User
* Build Number
* Passed Count
* Failed Count
* Skipped Count
* Report URL

### Email Notifications

Execution summary and report attachment are automatically emailed after every run.

---

## Running Tests Locally

Clone Repository:

```bash
git clone https://github.com/Anupg28/ApiAutomationCICD.git
```

Navigate to project:

```bash
cd ApiAutomationCICD
```

Execute Tests:

```bash
mvn clean test
```

Execute TestNG Suite:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## Maven Dependencies

Key dependencies used:

* Rest Assured
* TestNG
* Jackson Databind
* Gson
* JSON Simple
* Apache POI
* Selenium Java

---

## Skills Demonstrated

* API Automation Testing
* Rest Assured Framework Design
* TestNG Framework
* Data-Driven Testing
* JSON Parsing
* POJO Design Pattern
* Maven Project Management
* CI/CD Implementation
* GitHub Actions
* Automated Reporting
* Google Chat Integration
* Email Automation

---

## Future Enhancements

* Extent Reports Integration
* Environment Configuration Management
* Docker Support
* Parallel Execution
* API Schema Validation
* Jenkins Pipeline Integration
* Performance Testing Integration

---

## Author

Anup Ghodake

QA Automation Engineer

Skills:
Java | Rest Assured | Selenium | TestNG | API Testing | GitHub Actions | SQL | Manual Testing | CI/CD
