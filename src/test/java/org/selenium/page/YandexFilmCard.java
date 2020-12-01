package org.selenium.page;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Assert;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.BaseTest;
import java.io.*;
import java.net.*;
import static org.junit.Assert.assertTrue;

public class YandexFilmCard extends BaseTest {
    public WebDriver driver;

    public YandexFilmCard(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@Class='stream-program-title__subtitle stream-watching__player-header-subtitle']")
    private WebElement dataFilm;

    @FindBy(xpath = "//div[@Class='rating-vendor i-bem']")
    private WebElement ratingFilm;

    @Step("Date and rating check")
    public void checkDataRating() throws JSONException, IOException {

        //извлекаем дату
        String data = dataFilm.getText();
        String arr[] = data.split(" ", 2);
        String newdata = arr[0];

        //извлекаем рейтинг
        String rating = ratingFilm.getText();
        rating = rating.replace(",", ".");

        //округляем рейтинг
        float ratingFloat=Float.parseFloat(rating);
        ratingFloat-=0.1;
        String ratingStr = Float.toString(ratingFloat);
        String rating_kp = StringUtils.left(ratingStr, 3);

        //извлекаем ответ сервера
        String url = driver.getCurrentUrl();
        Document page = Jsoup.parse(new URL(url), 3000);

        //сортируем
        Elements metaElements = page.select("script");
        String metaEl = metaElements.toString();

        //проверка соответствия даты на странице и сервере
        assertTrue(metaEl.contains("\"release_year\":" + newdata));

        //проверка соответствия рейтинга на странице и сервере
        Assert.assertTrue(metaEl.contains("\"rating_kp\":" + rating) ||
                metaEl.contains("\"rating_kp\":" + rating_kp));
    }

}
