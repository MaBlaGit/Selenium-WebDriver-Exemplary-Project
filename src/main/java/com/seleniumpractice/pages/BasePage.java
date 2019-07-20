package com.seleniumpractice.pages;
import com.seleniumpractice.utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BasePage {

    public WebDriver driver;
    public Utilities utilities = new Utilities();

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        }
        this.driver.manage().window().fullscreen();
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
