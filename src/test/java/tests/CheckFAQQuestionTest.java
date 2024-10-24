package tests;

import org.junit.Test;
import pageobject.MainPage;

public class CheckFAQQuestionTest extends BaseUITest{
    @Test
    public void FAQQuestionsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFAQQuestion("Сколько это стоит? И как оплатить?");
    }
}
