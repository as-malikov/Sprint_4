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
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(NAME_INPUT));
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void userSurnameInput(String surname) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(SURNAME_INPUT));
        driver.findElement(SURNAME_INPUT).sendKeys(surname);
    }

    public void userAddressInput(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(ADDRESS_INPUT));
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    public void userMetroStationInput(String metroStation) {
        driver.findElement(SELECT_METRO_STATION_INPUT).click();
        By metroStationWithNameInput =  By.xpath(String.format(METRO_STATION_DIV, metroStation));
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(metroStationWithNameInput));
        driver.findElement(metroStationWithNameInput).click();
    }

    public void userPhoneNumberInput(String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(PHONE_NUMBER_INPUT));
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phoneNumber);
    }

    public void orderNextButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(ORDER_NEXT_BUTTON));
        driver.findElement(ORDER_NEXT_BUTTON).click();
    }

    public void selectedDeliveryDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(DELIVERY_DATE_INPUT));
        driver.findElement(DELIVERY_DATE_INPUT).sendKeys(date);
        driver.findElement(DELIVERY_DATE_DATA_PICKER).click();
    }
}
