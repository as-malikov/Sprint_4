package tests;

import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

import java.time.LocalDate;

import static Constants.OrderConstants.*;

public class CreateOrderInHeaderTest extends BaseUITest {

    @Test
    public void datePickerTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookiesClick();
        mainPage.headerOrderButtonClick();

        OrderPage orderPage = new OrderPage(driver);
        String deliveryDate = LocalDate.now().plusDays(1).toString();
        orderPage.userNameInput(NAME);
        orderPage.userSurnameInput(SURNAME);
        orderPage.userAddressInput(ADDRESS);
        orderPage.userMetroStationInput(METRO_STATION);
        orderPage.userPhoneNumberInput(PHONE_NUMBER);
        orderPage.orderNextButtonClick();

        orderPage.selectedDeliveryDate(deliveryDate);
    }
}
