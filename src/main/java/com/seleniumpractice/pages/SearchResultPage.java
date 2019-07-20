package com.seleniumpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

    WebDriver driver;
    WebElement element;
    WebDriverWait wait;

    @FindBy(className = "lighter")
    private WebElement searchedPeoductName;

    @FindBy(className = "heading-counter")
    WebElement zeroPrductWereFound;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String returnSearchedProductName(){
        WebElement productName = wait.until(ExpectedConditions.visibilityOf(this.searchedPeoductName));
        return productName.getText();
    }

    public String returnZeroProduct(){
        WebElement zeroProduct = wait.until(ExpectedConditions.visibilityOf(this.zeroPrductWereFound));
        return zeroProduct.getText().trim();
    }
}
