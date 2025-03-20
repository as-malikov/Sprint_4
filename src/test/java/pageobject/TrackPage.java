package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.Constants.FIVE_SECONDS;

public class TrackPage {

    public static String TRACK_PAGE_URL = "https://qa-scooter.praktikum-services.ru/track";
    public static final By notFoundImg = By.xpath(".//div[contains(@class,'Track_NotFound')]/img");

    protected WebDriver driver;

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public TrackPage openTrackPage() {
        driver.get(TRACK_PAGE_URL);
        return this;
    }

    public boolean isDisplayedNotFoundOrderImg() {
        new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS)).
                until(ExpectedConditions.visibilityOfElementLocated(notFoundImg));
        return driver.findElement(notFoundImg).isDisplayed();
    }
}
