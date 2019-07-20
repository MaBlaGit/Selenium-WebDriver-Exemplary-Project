package com.seleniumpractice.tests;

import com.github.javafaker.Faker;
import com.seleniumpractice.pages.AuthenticationPage;
import com.seleniumpractice.pages.BasePage;
import com.seleniumpractice.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegistrationAndLoginProcessTest extends BasePage {

    private Faker faker = new Faker();

    @Test(priority = 1)
    public void newUserCanCreateAccount() {
        MainPage mainPage = new MainPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        utilities.setUserEmail(faker.internet().emailAddress());
        utilities.setUserPassword("dummyPassword");

        mainPage.goTo();
        mainPage.clickOnLoginButton();
        authenticationPage.createAccount(utilities.getUserEmail());
        authenticationPage.fillRegistrationForm(
                faker.name().firstName(),
                faker.name().lastName(),
                utilities.getUserPassword(),
                faker.company().name(),
                faker.address().streetAddress(),
                faker.address().buildingNumber(),
                faker.address().city(),
                "85055",
                "Test",
                "687576444",
                "687969555");
        assertEquals(authenticationPage.getUserAccountPageHeader(), "MY ACCOUNT");
        authenticationPage.logOutFromAccount();
    }

    @Test(priority = 2)
    public void registeredUserCanLoginIntoAccount() {
        MainPage mainPage = new MainPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        mainPage.goTo();
        mainPage.clickOnLoginButton();
        authenticationPage.loginIntoAccount(utilities.getUserEmail(), utilities.getUserPassword());
        assertEquals(authenticationPage.getUserAccountPageHeader(), "MY ACCOUNT");
    }

}
