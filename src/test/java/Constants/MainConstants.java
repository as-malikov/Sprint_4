package Constants;

import org.openqa.selenium.By;

public class MainConstants {
    public static final By STATUS_ORDER_BUTTON = By.xpath(
            ".//button[contains(@class, 'Header_Link')]");
    public static final By ORDER_NUMBER_INPYT = By.xpath(
            ".//input[contains(@type, 'text')]");
    public static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and (contains(text(), '%s'))]";
    public static final String HOW_MUCH_COST_QUESTION = "Сколько это стоит? И как оплатить?";
    public static final String HOW_MUCH_COST_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String WANT_SOME_SCOOTER_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    public static final String WANT_SOME_SCOOTER_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String HOW_CALCULATE_RENT_TIME_QUESTION = "Как рассчитывается время аренды?";
    public static final String HOW_CALCULATE_RENT_TIME_ANSWER = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String CAN_ORDER_TODAY_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    public static final String CAN_ORDER_TODAY_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем " +
            "расторопнее.";
    public static final String CAN_EXTEND_ORDER_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    public static final String CAN_EXTEND_ORDER_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно " +
            "позвонить в поддержку по красивому номеру 1010.";
    public static final String GIVE_A_LIFT_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    public static final String GIVE_A_LIFT_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CAN_CANCEL_ORDER_QUESTION = "Можно ли отменить заказ?";
    public static final String CAN_CANCEL_ORDER_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String I_LIVE_FAR_QUESTION = "Я жизу за МКАДом, привезёте?";
    public static final String I_LIVE_FAR_ANSWER = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static By GO_BUTTON = By.xpath(
            ".//button[contains(@class, 'Header_Button') and text()='Go!']");
    public static By HEADER_ORDER_BUTTON = By.xpath(
            ".//div[contains(@class, 'Header_Nav')]/button[contains(@class,'Button_Button')]");
    public static By BODY_ORDER_BUTTON = By.xpath(
            ".//div[contains(@class, 'Home_FinishButton')]/button[contains(@class,'Button_Button')]");

}
