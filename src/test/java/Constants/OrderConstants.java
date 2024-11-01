package Constants;

import org.openqa.selenium.By;

public class OrderConstants {

    public static final String ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";

    public static final String NUMBER_ORDER = "45654654";
    public static final By NAME_INPUT = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Имя')]");
    public static final By SURNAME_INPUT = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Фамилия')]");
    public static final By ADDRESS_INPUT = By.xpath(".//div[contains(@class, 'Input_InputContainer')]" +
            "/input[contains(@placeholder, '* Адрес: куда привезти заказ')]");
    public static final String METRO_STATION_DIV = ".//div[contains(text(),'%s')]";
    public static final By SELECT_METRO_STATION_INPUT = By.xpath(".//input[contains(@class, 'select-search__input')]");
    public static final By PHONE_NUMBER_INPUT = By.xpath(".//div[contains(@class, 'Input_Input')]" +
            "/input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");
    public static final By ORDER_NEXT_BUTTON = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");
    public static final By DELIVERY_DATE_INPUT = By.xpath(".//input[contains(@placeholder," +
            "'* Когда привезти самокат')]");
    public static final By DELIVERY_DATE_DATA_PICKER = By.xpath(
            ".//div[contains(@class, 'react-datepicker__day--selected')]");
    public static final By RENT_ORDER_DIV = By.xpath(".//div[contains(@class,'Dropdown-placeholder')]");
    public static final String RENT_DAYS_DIV = ".//div[contains(@class,'Dropdown-option') " +
            "and contains(text(),'%s')]";
    public static String THREE_DAYS = "трое суток";
    public static final String COLLOR_ORDER_CHECKBOX_INPUT = ".//label[contains(text(), " +
            "'%s')]/input[contains(@class, 'Checkbox_Input')]";
    public static final String COLLOR = "серая безысходность";
    public static final String DESCRIPtION_ORDER = "Заберу у третьего подъезда";
    public static final By DESCRIPTION_FOR_COURIER_INPUT = By.xpath(".//input[contains(@class, " +
            "'Input_Responsible') and contains(@placeholder, 'Комментарий для курьера')]");
    public static final By FINAL_ORDER_BUTTON = By.xpath(".//button[contains(@class,'Button_Middle') " +
            "and contains(text(),'Заказать')]");
    public static final By YES_ORDER_BUTTON = By.xpath(".//button[contains(@class,'Button_Button') " +
            "and contains(text(),'Да')]");
    public static final By DONE_STATUS_ORDER_DIV = By.xpath(".//div[contains(@class, 'Order_ModalHeader') " +
            "and contains(text(),'Заказ оформлен')]");
    public static final String NAME = "Роман";
    public static final String SURNAME = "Самокатов";
    public static final String ADDRESS = "Красный проспект, 99";
    public static final String METRO_STATION = "Бульвар Рокоссовского";
    public static final String PHONE_NUMBER = "89239232323";
}
