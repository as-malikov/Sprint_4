package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageobject.Constants.FIVE_SECONDS;

import java.time.Duration;

public class OrderPage {

    public static final String ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";

    public static final By nameInput = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Имя')]");
    public static final By surnameInput = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Фамилия')]");
    public static final By addressInput = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    public static final String metroStationInput = ".//div[contains(text(),'%s')]";
    public static final By selectMetroStationInput = By.xpath(".//input[contains(@class, 'select-search__input')]");
    public static final By phoneNumberInput = By.xpath(".//div[contains(@class, 'Input_Input')]" +
            "/input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    public static final By orderNextInput = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");
    public static final By deliveryDateInput = By.xpath(".//input[contains(@placeholder," +
            "'* Когда привезти самокат')]");
    public static final By deliveryDateDataPicker = By.xpath(
            ".//div[contains(@class, 'react-datepicker__day--selected')]");
    public static final By rentOrderDiv = By.xpath(".//div[contains(@class,'Dropdown-placeholder')]");
    public static final String rentDaysDiv = ".//div[contains(@class,'Dropdown-option') " +
            "and contains(text(),'%s')]";
    public static String THREE_DAYS = "трое суток";
    public static final String colorOrderCheckboxInput = ".//label[contains(text(), " +
            "'%s')]/input[contains(@class, 'Checkbox_Input')]";

    public static final By descriptionForCourierInput = By.xpath(".//input[contains(@class, " +
            "'Input_Responsible') and contains(@placeholder, 'Комментарий для курьера')]");
    public static final By finalOrderButton = By.xpath(".//button[contains(@class,'Button_Middle') " +
            "and contains(text(),'Заказать')]");
    public static final By yesOrderButton = By.xpath(".//button[contains(@class,'Button_Button') " +
            "and contains(text(),'Да')]");
    public static final By doneStatusOrderDiv = By.xpath(".//div[contains(@class, 'Order_ModalHeader') " +
            "and contains(text(),'Заказ оформлен')]");

    protected WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void userNameInput(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        driver.findElement(nameInput).sendKeys(name);
    }

    public void userSurnameInput(String surname) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(surnameInput));
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void userAddressInput(String address) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(addressInput));
        driver.findElement(addressInput).sendKeys(address);
    }

    public void userMetroStationInput(String metroStation) {
        driver.findElement(selectMetroStationInput).click();
        By metroStationWithNameInput = By.xpath(String.format(metroStationInput, metroStation));
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(metroStationWithNameInput));
        driver.findElement(metroStationWithNameInput).click();
    }

    public void userPhoneNumberInput(String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput));
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void orderNextButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(orderNextInput));
        driver.findElement(orderNextInput).click();
    }

    public void selectedDeliveryDate(String date) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(deliveryDateInput));
        driver.findElement(deliveryDateInput).sendKeys(date);
        driver.findElement(deliveryDateDataPicker).click();
    }

    public void selectRentDays(String daysRent) {
        String rentDaysLocator = String.format(rentDaysDiv, daysRent);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(rentOrderDiv));
        driver.findElement(rentOrderDiv).click();
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(rentDaysLocator)));
        driver.findElement(By.xpath(rentDaysLocator)).click();
    }

    public void selectCollorScooter(String collor) {
        String collorLocator = String.format(colorOrderCheckboxInput, collor);
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(collorLocator)));
        driver.findElement(By.xpath(collorLocator)).click();
    }

    public void descriptionOrderInput(String description) {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(descriptionForCourierInput));
        driver.findElement(descriptionForCourierInput).sendKeys(description);
    }

    public void finishOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(finalOrderButton));
        driver.findElement(finalOrderButton).click();
    }

    public void yesButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.elementToBeClickable(yesOrderButton));
        driver.findElement(yesOrderButton).click();
    }

    public boolean isOrderDone() {
        return driver.findElement(doneStatusOrderDiv).isDisplayed();
    }
}
