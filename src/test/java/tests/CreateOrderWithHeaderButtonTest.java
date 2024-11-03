package tests;

import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static pageobject.Constants.*;
import static pageobject.OrderPage.THREE_DAYS;

public class CreateOrderWithHeaderButtonTest extends BaseUITest {

    @Test
    public void createOrderHeaderButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookiesClick();
        mainPage.headerOrderButtonClick();

        OrderPage orderPage = new OrderPage(driver);
        String deliveryDate = LocalDate.now().plusDays(ONE_DAY).toString();
        orderPage.userNameInput(NAME);
        orderPage.userSurnameInput(SURNAME);
        orderPage.userAddressInput(ADDRESS);
        orderPage.userMetroStationInput(METRO_STATION);
        orderPage.userPhoneNumberInput(PHONE_NUMBER);
        orderPage.orderNextButtonClick();

        orderPage.selectedDeliveryDate(deliveryDate);
        orderPage.selectRentDays(THREE_DAYS);
        orderPage.selectCollorScooter(COLLOR);
        orderPage.descriptionOrderInput(DESCRIPtION_ORDER);
        orderPage.finishOrderButtonClick();
        orderPage.yesButtonClick();
        boolean actual = orderPage.isOrderDone();
        assertEquals("Должен вернуть результат оформления заказа: ", true, actual);
    }
}
