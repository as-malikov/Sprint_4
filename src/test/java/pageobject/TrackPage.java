package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Constants.TrackConstants.*;

public class TrackPage {

    protected WebDriver driver;

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public TrackPage openTrackPage() {
        driver.get(TRACK_PAGE_URL);
        return this;
    }

    public boolean isDisplayedNotFoundOrderImg() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).
                until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMG));
        return driver.findElement(NOT_FOUND_IMG).isDisplayed();
    }
}
