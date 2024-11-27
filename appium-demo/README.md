
---

# Appium Project

## Project Overview
This project is designed to automate mobile application testing using [Appium](https://appium.io/). 

## Project Structure
```plaintext  
appium-tests/  
├── .idea/                    # IntelliJ IDEA project files  
├── allure-results/           # Allure test result files  
├── apps/                     # Mobile app files for testing  
│   └── app.apk               # APK file
├── src/  
│   ├── main/  
│   │   ├── java/  
│   │   │   ├── base/         # Base classes for test initialization  
│   │   │   ├── pages/        # Page Object Model (POM) classes  
│   │   │   ├── steps/        # Step definitions for actions  
│   │   │   └── utils/        # Utility classes and helpers  
│   └── test/  
│       ├── java/             # Test cases  
│       │   └── Tests.java    # Example test class  
│       └── resources/  
│           └── config.properties  # Configuration file for test setup  
├── pom.xml                   # Maven configuration file  
└── README.md                 # Project documentation  

```  

## Technology Stack
- **Appium**: For mobile app automation.
- **Java**: Programming language for test implementation.
- **TestNG**: Test framework for structuring and executing tests.
- **Maven**: Build tool for dependency management and test execution.

## Setup
### Prerequisites
1. **Java Development Kit (JDK)** installed (minimum version 8).
2. **Appium Server** installed and running.
3. **Android SDK** installed and configured.
4. Devices or Emulators configured for testing.

### Dependencies
The project uses Maven for dependency management. Key dependencies include:
- Appium Java Client
- TestNG

### Installation
1. Clone this repository:
   ```bash  
   git clone https://github.com/c0sminghinea/appium-tests.git  
   cd appium-tests  
   ```  
2. Install dependencies:
   ```bash  
   mvn clean install  
   ```  

## How to Run Tests
1. Start the Appium server:
   ```bash  
   appium  
   ```  
2. Execute the tests using Maven:
   ```bash  
   mvn test  
   ```  
3. Generate and view reports:
   ```bash  
   allure serve allure-results  
   ```  

## Approach
This project follows the **Page Object Model (POM)** design pattern for test automation.

### Why This Tech Stack?
- **Appium**: Versatile and supports cross-platform mobile testing.
- **TestNG**: Allows test grouping, parallel execution, and report generation.
- **Java**: Strong community support and integration with Appium.

## Key Features
- **Reusable Test Components**: Tests are modular and reusable, promoting efficiency.
- **Reporting**: Generates detailed reports for test execution using Allure.

---  
