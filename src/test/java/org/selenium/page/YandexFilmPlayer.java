package org.selenium.page;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;

public class YandexFilmPlayer extends BaseTest {
    public WebDriver driver;

    public YandexFilmPlayer(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@aria-label='Развернуть во весь экран']")
    private WebElement bigScreenButton;

    @FindBy(xpath = "//button[@aria-label='Остановить']")
    private WebElement reproduced;

    @FindBy(xpath = "//button[@aria-label='Воспроизвести']")
    private WebElement notreproduced;

    @FindBy(xpath = "//div[@Class='Swp5aqK']")
    private WebElement player;

    @FindBy(xpath = "//button[@aria-label='Выйти из полноэкранного режима']")
    private WebElement exitFullScreenmode;

    @Step("Open the Electronics tab")
    public void clickOnBigScreenButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(player).build().perform();
        bigScreenButton.click();
    }

    @Step("Open the Electronics tab")
    public void checkPlay() {
        Assert.assertTrue(reproduced.isDisplayed());
    }

    @Step("Exit full screen mode")
    public void clickOnESCAPE() {
        player.click();
        exitFullScreenmode.click();
    }
}
