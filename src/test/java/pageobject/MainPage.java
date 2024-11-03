package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.Constants.FIVE_SECONDS;

public class MainPage {

    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final By statusOrderButton = By.xpath(
            ".//button[contains(@class, 'Header_Link')]");
    public static final By orderNumberInput = By.xpath(
            ".//input[contains(@type, 'text')]");
    public static final By cookeButton = By.xpath(".//button[contains(@class,'App_CookieButton')]");
    public static final String faqQuestionPattern = ".//div[contains(@id, 'accordion__heading') " +
            "and (contains(text(), '%s'))]";
    public static final String faqAnswerPattern = ".//div[contains(@class,'accordion__panel') " +
            "and not(@hidden)]/p[contains(text(),'%s')]";

    public static By goButton = By.xpath(
            ".//button[contains(@class, 'Header_Button') and text()='Go!']");
    public static By headerOrderButton = By.xpath(
            ".//div[contains(@class, 'Header_Nav')]/button[contains(@class,'Button_Button')]");
    public static By bodyOrderButton = By.xpath(
            ".//div[contains(@class, 'Home_FinishButton')]/button[contains(@class,'Button_Button')]");

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public void cookiesClick() {
        if (driver.findElement(cookeButton).isDisplayed()) {
            driver.findElement(cookeButton).click();
        }
    }

    public void statusOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }

    public void setOrderNumberInput(String orderNumberValue) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        driver.findElement(orderNumberInput).clear();
        driver.findElement(orderNumberInput).sendKeys(orderNumberValue);
    }

    public void goButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    public void headerOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(headerOrderButton));
        driver.findElement(headerOrderButton).click();
    }

    public void bodyOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(bodyOrderButton));
        WebElement orderButtonElement = driver.findElement(bodyOrderButton);
        orderButtonElement.click();
    }

    public void clickFAQQuestion(String questionMessage) {
        By questionLocator = By.xpath(String.format(faqQuestionPattern, questionMessage));
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(questionLocator));
        WebElement questionElement = driver.findElement(questionLocator);
        scrollToElement(questionElement);
        questionElement.click();
    }

    public boolean findFAQAnswer(String answerMessage) {
        String answerLocator = String.format(faqAnswerPattern, answerMessage);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerLocator)));
        return driver.findElement(By.xpath(answerLocator)).isDisplayed();
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
