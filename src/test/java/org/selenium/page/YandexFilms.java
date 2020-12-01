package org.selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;

public class YandexFilms extends BaseTest {
    public WebDriver driver;

    public YandexFilms(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//div [@Class = 'Feed-Item Feed-Item_type_carousel'][2]//div [@Class = 'Carousel-Item Scroller-Item Grid-Item'][3]")
    private WebElement thirdFilmCard;

    @Step("Open the Electronics tab")
    public void clickOnThirdFilmCard() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thirdFilmCard);
        thirdFilmCard.click();
    }
}
