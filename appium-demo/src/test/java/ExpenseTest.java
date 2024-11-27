import io.appium.java_client.AppiumDriver;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import steps.ExpenseSteps;
import steps.HomePageSteps;
import steps.OnboardingSteps;
import utils.CustomAndroidDriver;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class ExpenseTest {

    private AppiumDriver driver;
    private HomePageSteps homePage;
    private ExpenseSteps expensePage;
    private OnboardingSteps onboarding;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new CustomAndroidDriver().getAndroidDriver();
        onboarding = new OnboardingSteps(driver);
        homePage = new HomePageSteps(driver);
        expensePage = new ExpenseSteps(driver);
    }

    @Test(description="Test the expense flow")
    public void testExpenseFlow() {

        // Execute the onboarding process
        onboarding.onboardingFlow();
        // Add a new expense
        homePage.clickExpense();
        expensePage.enterValue();
        expensePage.addNote();
        expensePage.selectFirstCategory();
        // Check total expense amount on dashboard
        homePage.checkExpenseTotal();
        // Update expense
        homePage.updateExpense();
        homePage.checkExpenseTotalAfterUpdate();
        // Delete expense
        homePage.deleteExpense();
        homePage.checkExpenseTotalAfterDeletion();
        //Check the total expense amount on dashboard
        homePage.checkExpenseTotalAfterDeletion();
    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
