package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ExpensePage;
import java.time.Duration;

public class ExpenseSteps {

    private final WebDriverWait wait;

    public ExpenseSteps(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
    @Step("Enter amount value")
    public void enterValue() {
        clickButton(ExpensePage.number5Button);
        clickButton(ExpensePage.number0Button);
    }
    @Step("Write a note")
    public void addNote() {
        WebElement noteField = wait.until(ExpectedConditions.elementToBeClickable(ExpensePage.noteField));
        noteField.sendKeys("test note");
    }
    @Step("Select the category")
    public void selectFirstCategory() {
        clickButton(ExpensePage.chooseCategoryButton);
        clickButton(ExpensePage.firstCategoryItem);
    }

}
