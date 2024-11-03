package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderWithBodyButtonTest extends BaseUITest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final int dateOrder;
    private final String daysOrder;
    private final String color;
    private final String description;
    private final boolean expected;

    public CreateOrderWithBodyButtonTest(String name, String surname, String address, String metroStation,
                                         String phoneNumber, int dateOrder, String daysOrder, String color,
                                         String description, boolean expected) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dateOrder = dateOrder;
        this.daysOrder = daysOrder;
        this.color = color;
        this.description = description;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getDataOrder() {
        return new Object[][]{
                {"Роман", "Печенькин", "ул.Мира, д.25, кв.7", "Черкизовская", "82342344343", 1, "трое суток",
                        "серая безысходность", "Заберу у подъезда", true},
                {"Джим ", "Кларк", "ул.Киларми, д.3", "Бульвар Рокоссовского", "89999999999", 2, "двое суток",
                        "чёрный жемчуг", "Предварительно позвонить", true}
        };
    }

    @Test
    public void createOrderWithBodyBottonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookiesClick();
        mainPage.bodyOrderButtonClick();

        OrderPage orderPage = new OrderPage(driver);
        String deliveryDate = LocalDate.now().plusDays(dateOrder).toString();
        orderPage.userNameInput(name);
        orderPage.userSurnameInput(surname);
        orderPage.userAddressInput(address);
        orderPage.userMetroStationInput(metroStation);
        orderPage.userPhoneNumberInput(phoneNumber);
        orderPage.orderNextButtonClick();

        orderPage.selectedDeliveryDate(deliveryDate);
        orderPage.selectRentDays(daysOrder);
        orderPage.selectCollorScooter(color);
        orderPage.descriptionOrderInput(description);
        orderPage.finishOrderButtonClick();
        orderPage.yesButtonClick();
        boolean actual = orderPage.isOrderDone();
        assertEquals("Должен вернуть результат оформления заказа: ", expected, actual);
    }
}
