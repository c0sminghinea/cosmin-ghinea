### Exploratory Testing Report: Android Mobile Application

#### **Platform Used**
- **Device**: Android emulator (Pixel 5, Android 14.0)
- **App Version**: 1.18

---

### **Exploratory Testing Charters**

| **Charter ID** | **Focus Area**                  | **Description**                                                                                         | **Test Scenarios**                                                                                                                                                                | **Priority** |
|----------------|---------------------------------|---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------|
| **C1**         | **App Installation and Launch** | Ensure the app installs successfully, launches correctly, and displays the first onboarding screen.     | 1. Test installation from Play Store. <br> 2. Verify correct behavior during first launch. <br> 3. Assess performance under different OS versions and devices.                    | **High**     |
| **C2**         | **Onboarding flow**             | Assess the user experience, performance, and accuracy of onboarding screens and their guidance ability. | 1. Verify the onboarding flow. <br> 2. Integration of hints guiding the user through key app features. <br> 3. Check onboarding multi-language support.                           | **High**     |
| **C3**         | **Basic Expense Tracking flow** | Validate the functionality of adding, editing, and deleting expenses, as well as tracking income.       | 1. Add an expense and validate it in the summary view. <br> 2. Edit a previously added expense and verify updates. <br> 3. Delete an expense and check for accurate graph update. | **High**     |
| **C4**         | **Data Visualization**          | Assess the accuracy and responsiveness of the graphs and charts used for financial summaries.           | 1. Switch between daily, weekly, and monthly views. <br> 2. Add multiple expenses and verify their impact on graphs. <br> 3. Test responsiveness on screen swipe.                 | **Medium**   |
| **C6**         | **App Settings and Customization** | Test the ability to change settings like default currency, balance, and backup data.                    | 1. Change the default currency and verify its impact. <br> 2. Check all the balance features.(e.g.budget mode) <br> 3. Test backup and restore to/from Google Drive.              | **Medium**   |
| **C7**         | **Localization and Usability**  | Examine the app's behavior in different languages and its overall navigation responsiveness.            | 1. Change language settings and validate translations. <br> 2. Test on smaller screen devices for UI responsiveness. <br> 3. Validate labels, icons, and buttons for usability.   | **Low**      |

---

### **Findings from Charters**

#### **C1: App Installation and Launch**
- **Outcome**: Successful installation and launch
- **Findings**:
    - **Bug**: On fold devices, the onboarding tutorial can be improved, as some tooltips don't point to the correct elements.
    - **Bug**: On fold devices the tooltip related to the main currency is not entirely displayed on the screen.
    - **Bug**: If the user scrolls the settings menu, the tooltip is not linked dynamically to the Currencies element and can be confusing.
    - **Suggestion**: Optimize app for folded devices in order to be displayed on the entire screen.

---

#### **C2: Onboarding flow**
- **Outcome**: The onboarding provides an engaging introduction. While the core functionality of the flow works, several issues were observed:
- **Findings**:
  - **Bug**: On fold devices, the onboarding tutorial can be improved, as some info red bubbles don't point to the correct elements.
  - **Bug**: On fold devices the info bubble related to the main currency is not entirely displayed on the screen.
  - **Bug**: If the user scrolls the settings menu, the info bubble is not linked dynamically to the Currencies element and can be confusing.
  - **Bug**: Language support not working on the onboarding flow. 
  - **Suggestion**: The onboarding flow is visually appealing but lacks explanation of certain advanced features.

---

#### **C3: Basic Expense/Income flow**
- **Outcome**: Core functionality worked but some bugs were found.
- **Findings**:
    - **Bug**: The use of the built-in calculator when adding an expense can be confusing due to not showing the entire calculation.
    - **Bug**: After adding an expense, the confirmation pop-up stays too much on the screen blocking expense/income buttons. 
    - **UX Issue**: Confirmation pop-up should appear below the expense/income buttons.
    - **Bug**: If expense note is longer than 45chars, becomes difficult to read.

---

#### **C4: Data Visualization**
- **Outcome**: Functional but  data display in edge cases.
- **Findings**:
    - **Bug**: Decimal missing for expenses under 0%. 
    - **Bug**: Pie Chart Misalignment: Categories beyond 10 displayed randomly without connecting lines to slices 
    - **UX Issue**: Poor alignment of graph legends on smaller screens.

---

#### **C5: App Settings and Customization**
- **Outcome**: Mostly functional but bugs were found.
- **Findings**:
    - **Bug**: In-App Purchase Screen not translated in any language than english.
    - **Bug**: Currency order in the list can be improved based on popularity.
    - **Bug**: Currency menu doesn't have a close button which forces the user to select a currency everytime.
    - **Bug**: Currency search results are inconsistent and include irrelevant matches (e.g., Searching "RON" displays "DKK, ISK, NOK, RON").

---

#### **C6: Localization and Usability**
- **Outcome**: Usable but inconsistent in other languages.
- **Findings**:
    - **Bug**: Missing translations in several languages.
    - **UX Issue**: On devices with small screens (4.7 inches), critical buttons were either truncated or inaccessible without scrolling.
    - **Suggestion**: Conduct usability testing with users from multiple regions to refine localization.

---

### **Risks to Mitigate for this Application**

1. **Data Integrity**
    - Risk: Incorrect data calculations or visualizations (e.g., graphs, totals) can mislead users and harm the app’s credibility.
    - Mitigation: Introduce robust test cases to cover edge scenarios such as rapid data changes, large numbers.

2. **Performance Bottlenecks**
    - Risk: Delays or crashes during backups, conversions, or graph loading could frustrate users.
    - Mitigation: Conduct performance profiling under stress conditions, including low network connectivity and large datasets.

3. **Concurrency Issues**
    - Risk: Asynchronous operations causing duplicate or incorrect data entries.
    - Mitigation: Implement and test thread-safe logic for all data-handling operations.

4. **Accessibility Challenges**
    - Risk: Poor UX in dark mode and for smaller screens can alienate users.
    - Mitigation: Include accessibility testing with automated tools (e.g., Lighthouse) and manual reviews.

5. **Security Risks**
    - Risk: Potential vulnerabilities in data backup and restoration processes could lead to data breaches.
    - Mitigation: Encrypt sensitive data during backup and test compliance with security best practices.

---

### **Prioritization of Charters**

| **Priority** | **Charters** | **Reason**                                                                                 |
|--------------|------------|--------------------------------------------------------------------------------------------|
| **High**     | **C1, C2, C3** | Installation and expense/income tracking are core to the app’s functionality.              |
| **Medium**   | **C4, C5** | Visualization, multi-currency handling, and settings enhance experience but are secondary. |
| **Low**      | **C6**     | Localization and minor usability issues don’t severely impact app usability.               |

---
