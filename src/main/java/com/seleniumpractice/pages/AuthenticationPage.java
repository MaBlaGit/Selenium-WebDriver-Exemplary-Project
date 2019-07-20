package com.seleniumpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class AuthenticationPage {

    WebDriver driver;
    WebDriverWait wait;
    WebElement element;

    @FindBy(className = "navigation_page")
    private WebElement authenticationBreadcrumb;

    @FindBy(name = "email_create")
    private WebElement emailInputFieldNewUser;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "email")
    private WebElement emailInputFieldRegistered;

    @FindBy(id = "passwd")
    private WebElement passwordInputField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "id_gender1")
    private WebElement titleRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "firstname")
    private WebElement firstNameSecondInputField;

    @FindBy(id = "lastname")
    private WebElement lastNameSecondInputField;

    @FindBy(id = "company")
    private WebElement companyInputField;

    @FindBy(id = "address1")
    private WebElement addressOneInputField;

    @FindBy(id = "address2")
    private WebElement addressTwoInputField;

    @FindBy(id = "city")
    private WebElement cityInputField;

    @FindBy(id = "uniform-id_state")
    private WebElement stateDropdown;

    @FindBy(id = "id_state")
    private WebElement stateCountry;

    @FindBy(id = "postcode")
    private WebElement zipPostalCode;

    @FindBy(id = "other")
    private WebElement additionalInfoTextarea;

    @FindBy(id = "phone")
    private WebElement phoneInputField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInputField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(className = "page-heading")
    private WebElement userAccountPageHeader;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public AuthenticationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String getAuthenticationBreadcrumbs(){
        WebElement authBreadcrumb = wait.until(ExpectedConditions.visibilityOf(this.authenticationBreadcrumb));
        return authBreadcrumb.getText().trim();
    }

    public void loginIntoAccount(String email, String password){
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOf(this.emailInputFieldRegistered));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOf(this.passwordInputField));
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOf(this.signInButton));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();

    }

    public void createAccount(String userEmail){
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOf(this.emailInputFieldNewUser));
        emailInputField.sendKeys(userEmail);
        this.createAnAccountButton.click();
    }

    public void fillRegistrationForm(String firstName,
                                     String lastName,
                                     String password,
                                     String company,
                                     String addressOne,
                                     String addressTwo,
                                     String city,
                                     String zipPostalCode,
                                     String additionalInfo,
                                     String homePhoneNumber,
                                     String mobilePhoneNumber){
        WebElement titleRadio = wait.until(ExpectedConditions.elementToBeClickable(this.titleRadioButton));
        titleRadio.click();
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
        this.passwordInputField.sendKeys(password);
        this.firstNameSecondInputField.sendKeys(firstName);
        this.lastNameSecondInputField.sendKeys(lastName);
        this.companyInputField.sendKeys(company);
        this.addressOneInputField.sendKeys(addressOne);
        this.addressTwoInputField.sendKeys(addressTwo);
        this.cityInputField.sendKeys(city);

        Select select = new Select(this.stateCountry);
        select.selectByIndex(5);

        this.zipPostalCode.sendKeys(zipPostalCode);
        this.additionalInfoTextarea.sendKeys(additionalInfo);
        this.phoneInputField.sendKeys(homePhoneNumber);
        this.mobilePhoneInputField.sendKeys(mobilePhoneNumber);

        this.registerButton.click();
    }

    public String getUserAccountPageHeader(){
        WebElement userAccountPageHeader = wait.until(ExpectedConditions.visibilityOf(this.userAccountPageHeader));
        return userAccountPageHeader.getText();
    }

    public void logOutFromAccount(){
        this.logoutButton.click();
    }

}
