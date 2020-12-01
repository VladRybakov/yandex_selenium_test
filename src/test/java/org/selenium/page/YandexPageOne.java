package org.selenium.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;

public class YandexPageOne extends BaseTest {
    public WebDriver driver;

    public YandexPageOne(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//div[@class='services-new__more-icons']")
    private WebElement more;

    @FindBy(xpath="//*[text()='Эфир']")
    private WebElement ether;


    @Step("Click on more")
    public void clickOnMore() {
        more.click();
    }

    @Step("Open the Ether")
    public void clickOnEther() {
        ether.click();
    }
}

