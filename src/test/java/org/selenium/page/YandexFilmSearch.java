package org.selenium.page;

import io.qameta.allure.Step;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class YandexFilmSearch extends BaseTest {
    public WebDriver driver;

    public YandexFilmSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='uniq15887768464221']")
    private WebElement search;

    @FindBy(xpath = "//button[@class='websearch-button suggest2-form__button i-bem websearch-button_js_inited']")
    private WebElement enter;

    @FindBy(xpath = "//div[@class='Feed-Item Feed-Item_type_card Grid-Item'][1]//a[@title='Апгрейд']")
    private WebElement searchResult;

    @FindBy(xpath="//div[@class='Cut Cut_2-16 IconSet-Text BaseCard-TopReasonText'] [text()='2018 • фантастика, боевик, триллер, детектив, криминал']")
    private WebElement searchResultOptions;

    @FindBy(xpath="//div[@class='Feed-Item Feed-Item_type_card Grid-Item']")
    private WebElement searchSize;

    @Step("Exit full screen mode")
    public void clickOnSearch() {
        search.click();
    }

    @Step("Enter the amount from Апгрейд")
    public void enterRequest()  {
        driver.findElement(By.xpath("//input[@id='uniq15887768464221']")).sendKeys("Апгрейд");
    }

    @Step("Enter")
    public void enter() throws AWTException, InterruptedException {
        Thread.sleep(2000);
        enter.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Step("Check search")
    public void checkSearch() throws JSONException, IOException {

        //проверяем что первая карточка книги соответсвует запросу
        assertTrue(searchResult.isDisplayed());

        //проверяем что параметры год жанры отображаются на карточке
        assertTrue(searchResultOptions.isDisplayed());

        //параметры с сервера и колличество карточек через url проверить не удалось
        //список фильмов запрашивается через graphql
    }
}
