package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.OnboardingPage;

import java.time.Duration;

public class OnboardingSteps {
    private final WebDriverWait wait;
    private static final int CONTINUE_BUTTON_CLICKS = 3;

    public OnboardingSteps(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }
    @Step("Execute the onboarding process")
    public void onboardingFlow() {

        for (int i = 0; i < CONTINUE_BUTTON_CLICKS; i++) {

            clickButton(OnboardingPage.continueButton);
        }
        clickButton(OnboardingPage.closeButton);
    }


}
