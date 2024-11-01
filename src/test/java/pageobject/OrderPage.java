package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.OrderConstants.*;

import java.time.Duration;

public class OrderPage {

    protected WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userNameInput(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void userSurnameInput(String surname) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(SURNAME_INPUT));
        driver.findElement(SURNAME_INPUT).sendKeys(surname);
    }

    public void userAddressInput(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_INPUT));
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    public void userMetroStationInput(String metroStation) {
        driver.findElement(SELECT_METRO_STATION_INPUT).click();
        By metroStationWithNameInput = By.xpath(String.format(METRO_STATION_DIV, metroStation));
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(metroStationWithNameInput));
        driver.findElement(metroStationWithNameInput).click();
    }

    public void userPhoneNumberInput(String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_INPUT));
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phoneNumber);
    }

    public void orderNextButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(ORDER_NEXT_BUTTON));
        driver.findElement(ORDER_NEXT_BUTTON).click();
    }

    public void selectedDeliveryDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(DELIVERY_DATE_INPUT));
        driver.findElement(DELIVERY_DATE_INPUT).sendKeys(date);
        driver.findElement(DELIVERY_DATE_DATA_PICKER).click();
    }

    public void selectRentDays(String daysRent) {
        String rentDaysLocator = String.format(RENT_DAYS_DIV, daysRent);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(RENT_ORDER_DIV));
        driver.findElement(RENT_ORDER_DIV).click();
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(rentDaysLocator)));
        driver.findElement(By.xpath(rentDaysLocator)).click();
    }

    public void selectCollorScooter(String collor) {
        String collorLocator = String.format(COLLOR_ORDER_CHECKBOX_INPUT, collor);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(collorLocator)));
        driver.findElement(By.xpath(collorLocator)).click();
    }

    public void descriptionOrderInput(String description) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(DESCRIPTION_FOR_COURIER_INPUT));
        driver.findElement(DESCRIPTION_FOR_COURIER_INPUT).sendKeys(description);
    }

    public void finishOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.visibilityOfElementLocated(FINAL_ORDER_BUTTON));
        driver.findElement(FINAL_ORDER_BUTTON).click();
    }

    public void yesButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_ORDER)).
                until(ExpectedConditions.elementToBeClickable(YES_ORDER_BUTTON));
        driver.findElement(YES_ORDER_BUTTON).click();
    }

    public boolean isOrderDone() {
        return driver.findElement(DONE_STATUS_ORDER_DIV).isDisplayed();
    }
}
