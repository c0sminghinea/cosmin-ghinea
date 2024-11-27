package steps;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.ExpensePage;
import utils.ConfigLoader;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    private final WebDriverWait wait;

    public HomePageSteps(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    private void deleteEntry() {
        clickButton(HomePage.expenseCategoryTitle);
        clickButton(HomePage.expenseEntry);
        clickButton(HomePage.deleteExpenseButton);
    }

    private void updateEntry() {
        clickButton(HomePage.balanceButton);
        clickButton(HomePage.expenseCategoryTitle);
        clickButton(HomePage.expenseEntry);
        clickButton(ExpensePage.clearButton);
        clickButton(ExpensePage.chooseCategoryButton);
        clickButton(ExpensePage.firstCategoryItem);
    }
    @Step("Click on the expense button")
    public void clickExpense() {
        clickButton(HomePage.expenseButton);
    }
    @Step("Click on the income button")
    public void clickIncome() {
        clickButton(HomePage.incomeButton);
    }
    @Step("Update expense")
    public void updateExpense() {
        updateEntry();
    }
    @Step("Update income")
    public void updateIncome() {
        updateEntry();
    }
    @Step("Delete expense")
    public void deleteExpense() {
        deleteEntry();
    }
    @Step("Delete income")
    public void deleteIncome() {
        deleteEntry();
    }
    @Step("Check total expenses")
    public void checkExpenseTotal() {
        String expectedValue = ConfigLoader.getProperty("expected.expense.new", "nuLL");
        WebElement expenseAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.expenseAmountText));
        String elementText = expenseAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
    @Step("Check total income")
    public void checkIncomeTotal() {
        String expectedValue = ConfigLoader.getProperty("expected.income.new", "nuLL");
        WebElement incomeAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.incomeAmountText));
        String elementText = incomeAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
    @Step("Check total expenses after update")
    public void checkExpenseTotalAfterUpdate() {
        String expectedValue = ConfigLoader.getProperty("expected.expense.updated", "nuLL");
        WebElement expenseAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.expenseAmountText));
        String elementText = expenseAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
    @Step("Check total income after update")
    public void checkIncomeTotalAfterUpdate() {
        String expectedValue = ConfigLoader.getProperty("expected.income.updated", "10");
        WebElement incomeAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.incomeAmountText));
        String elementText = incomeAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
    @Step("Check total expenses after deletion")
    public void checkExpenseTotalAfterDeletion() {
        String expectedValue = ConfigLoader.getProperty("expected.expense.deleted", "nuLL");
        WebElement expenseAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.expenseAmountText));
        String elementText = expenseAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
    @Step("Check total income after deletion")
    public void checkIncomeTotalAfterDeletion() {
        String expectedValue = ConfigLoader.getProperty("expected.income.deleted", "nuLL");
        WebElement incomeAmountText = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.incomeAmountText));
        String elementText = incomeAmountText.getText();
        assertTrue(elementText.contains(expectedValue), "Wrong total value. Actual text: " + elementText);
    }
}
