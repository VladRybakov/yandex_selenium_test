package org.selenium;

import io.qameta.allure.Attachment;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.page.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static YandexPageOne onePage;
    public static YandexPageTwo twoPage;
    public static YandexMyPurchases myPurchases;
    public static YandexFilms films;
    public static YandexFilmCard filmsCard;
    public static YandexFilmPlayer player;
    public static YandexFilmSearch search;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");

        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        twoPage = new YandexPageTwo(driver);
        onePage = new YandexPageOne(driver);
        myPurchases = new YandexMyPurchases(driver);
        films = new YandexFilms(driver);
        filmsCard = new YandexFilmCard(driver);
        player = new YandexFilmPlayer(driver);
        search = new YandexFilmSearch(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("yandex"));
    }

    public static void switchToLastPage() {
        for (String windowsHandler : driver.getWindowHandles()) {
            driver.switchTo().window(windowsHandler);
        }
    }

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
