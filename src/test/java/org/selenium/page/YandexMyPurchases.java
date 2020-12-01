package org.selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;

import static org.junit.Assert.assertTrue;

public class YandexMyPurchases extends BaseTest {
    public WebDriver driver;

    public YandexMyPurchases(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//div[@Class='EmptyScreen Screen-Empty']//div[@Class='EmptyScreen-Title']")
    private WebElement emptyScreenTitle;

    @FindBy(xpath="//div[@Class='EmptyScreen Screen-Empty']//div[@Class='EmptyScreen-Subtitle']")
    private WebElement emptyScreenSubtitle;

    @Step("Check empty screen")
    public void checkEmptyScreen() {
        assertTrue(emptyScreenTitle.getText().contains("Покупок пока нет"));
        assertTrue(emptyScreenSubtitle.getText().contains("Покупайте и смотрите новинки не выходя из дома"));
    }
}
