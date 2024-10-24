package tests;

import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.TrackPage;

public class CheckStatusOrderTest extends BaseUITest {

    private final String numberOrder = "45654654";

    @Test
    public void checkOrderStatusNotExistTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.statusOrderButtonClick();
        mainPage.setOrderNumberInput(numberOrder);
        mainPage.goButtonClick();

        TrackPage trackPage = new TrackPage(driver);
        boolean isDisplayedNotFoundOrderImg = trackPage.isDisplayedNotFoundOrderImg();
        Assert.assertTrue("Должен возвращать True если найден notFoundImg: ", isDisplayedNotFoundOrderImg);
    }


}
