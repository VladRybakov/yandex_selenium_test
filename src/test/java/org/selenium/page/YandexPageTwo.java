package org.selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;

public class YandexPageTwo extends BaseTest {
    public WebDriver driver;

    public YandexPageTwo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//section[@class='Section'][2]//div[@class='Section-Item'][2]//a[@class='StreamLink StreamLink_block']")
    private WebElement myPurchases;

    @FindBy(xpath="//*[text()='Фильмы']")
    private WebElement films;

    @Step("Click On My Purchases")
    public void clickOnMyPurchases() {
        switchToLastPage();
        myPurchases.click();
    }

    @Step("Open the Films")
    public void clickOnFilms() {
        films.click();
    }
}
