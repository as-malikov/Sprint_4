package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constants.MainConstants.*;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public void cookiesClick() {
        if (driver.findElement(COOKIE_BUTTON).isDisplayed()) {
            driver.findElement(COOKIE_BUTTON).click();
        }
    }

    public void statusOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.elementToBeClickable(STATUS_ORDER_BUTTON));
        driver.findElement(STATUS_ORDER_BUTTON).click();
    }

    public void setOrderNumberInput(String orderNumberValue) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPYT));
        driver.findElement(ORDER_NUMBER_INPYT).clear();
        driver.findElement(ORDER_NUMBER_INPYT).sendKeys(orderNumberValue);
    }

    public void goButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.elementToBeClickable(GO_BUTTON));
        driver.findElement(GO_BUTTON).click();
    }

    public void headerOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.elementToBeClickable(HEADER_ORDER_BUTTON));
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void bodyOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.elementToBeClickable(BODY_ORDER_BUTTON));
        WebElement orderButtonElement = driver.findElement(BODY_ORDER_BUTTON);
        orderButtonElement.click();
    }

    public void clickFAQQuestion(String questionMessage) {
        By questionLocator = By.xpath(String.format(FAQ_QUESTION_PATTERN, questionMessage));
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.visibilityOfElementLocated(questionLocator));
        WebElement questionElement = driver.findElement(questionLocator);
        scrollToElement(questionElement);
        questionElement.click();
    }

    public boolean findFAQAnswer(String answerMessage) {
        String answerLocator = String.format(FAQ_ANSWER_PATTERN, answerMessage);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_MAIN)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerLocator)));
        return driver.findElement(By.xpath(answerLocator)).isDisplayed();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
