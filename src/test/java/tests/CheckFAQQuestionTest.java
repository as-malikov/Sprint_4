package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;

import static Constants.MainConstants.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckFAQQuestionTest extends BaseUITest {
    private final String question;
    private final String answer;
    private final boolean result;

    public CheckFAQQuestionTest(String question, String answer, boolean result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {HOW_MUCH_COST_QUESTION, HOW_MUCH_COST_ANSWER, true},
                {WANT_SOME_SCOOTER_QUESTION, WANT_SOME_SCOOTER_ANSWER, true},
                {HOW_CALCULATE_RENT_TIME_QUESTION, HOW_CALCULATE_RENT_TIME_ANSWER, true},
                {CAN_ORDER_TODAY_QUESTION, CAN_ORDER_TODAY_ANSWER, true},
                {CAN_EXTEND_ORDER_QUESTION, CAN_EXTEND_ORDER_ANSWER, true},
                {GIVE_A_LIFT_QUESTION, GIVE_A_LIFT_ANSWER, true},
                {CAN_CANCEL_ORDER_QUESTION, CAN_CANCEL_ORDER_ANSWER, true},
                {I_LIVE_FAR_QUESTION, I_LIVE_FAR_ANSWER, true}
        };
    }

    @Test
    public void FAQQuestionsTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFAQQuestion(question);
        assertEquals("Должен отобразить ответ на вопрос в аккардион панели: ", result, mainPage.findFAQAnswer(answer));
    }
}
