package com.seleniumpractice.tests;

import com.seleniumpractice.pages.BasePage;
import com.seleniumpractice.pages.MainPage;
import static org.testng.Assert.*;

import com.seleniumpractice.pages.SearchResultPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;

public class SearchProductTest extends BasePage {

    private String csvFile = "./src/main/resources/search-product-data.csv";

    @DataProvider(name = "searched-products")
    public Iterator<String []> searchedProductList(){
        return utilities.csvDataReader(csvFile).iterator();
    }

    @Test(dataProvider = "searched-products")
    public void searchProductsTest(String searchedProduct, String quantity, String isPresented){

        boolean isProductExists = Boolean.valueOf(isPresented);
        MainPage mainPage = new MainPage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        mainPage.goTo();
        mainPage.searchProduct(searchedProduct);
        if(isProductExists){
            assertEquals(searchResultPage.returnSearchedProductName(), '"' + searchedProduct.toUpperCase() + '"');
        } else {
            assertEquals(searchResultPage.returnZeroProduct(), "0 results have been found.");
        }
    }
}
