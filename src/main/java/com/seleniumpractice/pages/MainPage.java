package com.seleniumpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private WebDriver driver;
    WebElement element;
    private WebDriverWait wait;

    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(id="search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchSubmitButton;

    @FindBy(css = "#homefeatured >li>div")
    private List<WebElement> featuredProductContainer;

    @FindBy(xpath = "//span[contains(text(), 'Add to cart')]")
    List<WebElement> addToCartButton;

    @FindBy(css = "a>span.ajax_cart_quantity")
    WebElement numberOfAddedProducts;

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

    public void addAllFeaturedProductsToTheCart() {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)driver);

        Actions action = new Actions(driver);
        List<WebElement> featuredProducts = wait.until(
                ExpectedConditions.visibilityOfAllElements(this.featuredProductContainer));

        for(int i=0; i<featuredProducts.size(); i++) {
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", featuredProducts.get(i));
            action.moveToElement(featuredProducts.get(i)).
                    pause(3000).
                    moveToElement(addToCartButton.get(i)).
                    click().
                    pause(3000).
                    moveToElement(driver.findElement(By.cssSelector("span>i.icon-chevron-left"))).
                    click().
                    perform();
        }
    }

    public int getFeaturedProductsNumber(){
        return this.featuredProductContainer.size();
    }

    public int getCurrentCartProductsNumber(){
        return Integer.parseInt(this.numberOfAddedProducts.getText());
    }

}
