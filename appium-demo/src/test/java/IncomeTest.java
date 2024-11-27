import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.ExpenseSteps;
import steps.HomePageSteps;
import steps.OnboardingSteps;
import utils.CustomAndroidDriver;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class IncomeTest {
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

    @Test
    public void testIncomeFlow() {
        // Execute the onboarding process
        onboarding.onboardingFlow();
        // Add a new expense
        homePage.clickIncome();
        expensePage.enterValue();
        expensePage.addNote();
        expensePage.selectFirstCategory();
        // Check total expense amount on dashboard
        homePage.checkIncomeTotal();
        // Update income
        homePage.updateIncome();
        homePage.checkIncomeTotalAfterUpdate();
        // Delete income
        homePage.deleteIncome();
        //Check the total income amount on dashboard
        homePage.checkIncomeTotalAfterDeletion();
    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}