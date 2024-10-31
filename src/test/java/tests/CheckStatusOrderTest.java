package tests;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.TrackPage;

import static Constants.OrderConstants.NUMBER_ORDER;

public class CheckStatusOrderTest extends BaseUITest {

    @Test
    public void checkOrderStatusNotExistTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumberInput(NUMBER_ORDER);
        mainPage.goButtonClick();

        TrackPage trackPage = new TrackPage(driver);
        boolean isDisplayedNotFoundOrderImg = trackPage.isDisplayedNotFoundOrderImg();
        Assert.assertTrue("Должен возвращать True если найден notFoundImg: ", isDisplayedNotFoundOrderImg);
    }
}
