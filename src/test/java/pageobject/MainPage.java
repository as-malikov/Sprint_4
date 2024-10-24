package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public void statusOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.elementToBeClickable(STATUS_ORDER_BUTTON));
        driver.findElement(STATUS_ORDER_BUTTON).click();
    }

    public void setOrderNumberInput(String orderNumberValue) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(ORDER_NUMBER_INPYT));
        driver.findElement(ORDER_NUMBER_INPYT).clear();
        driver.findElement(ORDER_NUMBER_INPYT).sendKeys(orderNumberValue);
    }

    public void goButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.elementToBeClickable(GO_BUTTON));
        driver.findElement(GO_BUTTON).click();
    }

    public void headerOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.elementToBeClickable(HEADER_ORDER_BUTTON));
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void clickFAQQuestion(String questionMessage) {
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        System.out.println(questionLocator);
        By questionXPath = By.xpath(questionLocator);
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.elementToBeClickable(questionXPath));
        driver.findElement(questionXPath).click();
    }
}
