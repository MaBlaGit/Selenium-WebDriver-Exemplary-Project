package com.seleniumpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    WebElement element;
    private WebDriverWait wait;

    @FindBy(className = "login")
    WebElement loginButton;

    @FindBy(id="search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchSubmitButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("http://automationpractice.com/index.php");
    }

    public void clickOnLoginButton(){
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        loginButton.click();
    }

    public void searchProduct(String productName) {
        WebElement searchInputField = wait.until(ExpectedConditions.visibilityOf(this.searchInput));
        searchInputField.sendKeys(productName);
        searchSubmitButton.click();
    }

}
