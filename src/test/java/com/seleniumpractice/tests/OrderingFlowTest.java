package com.seleniumpractice.tests;

import com.seleniumpractice.pages.BasePage;
import com.seleniumpractice.pages.MainPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class OrderingFlowTest extends BasePage {

    @Test
    public void addSelectedProductToTheCart() {
        MainPage mainPage = new MainPage(driver);

        mainPage.goTo();
        mainPage.addAllFeaturedProductsToTheCart();
        assertEquals(mainPage.getCurrentCartProductsNumber(), mainPage.getFeaturedProductsNumber());
    }
}
