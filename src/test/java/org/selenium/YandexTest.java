package org.selenium;

import org.json.JSONException;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

public class YandexTest extends BaseTest {

    @Test
    public void YandexFilmTest() throws InterruptedException, JSONException, IOException, AWTException {

        onePage.clickOnMore();
        onePage.clickOnEther();
        twoPage.clickOnMyPurchases();
        myPurchases.checkEmptyScreen();
        twoPage.clickOnFilms();
        films.clickOnThirdFilmCard();
        filmsCard.checkDataRating();
        player.clickOnBigScreenButton();
        player.checkPlay();
        player.clickOnESCAPE();
        search.clickOnSearch();
        search.enterRequest();
        search.enter();
        search.checkSearch();
    }

}
