package StepDefination;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefination {
    TestContextSetup testContextSetup;


    public GreenKartStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {

        Assert.assertTrue(testContextSetup.pageObjectManager.getLandingPage().getTitleLandingPage().contains("GreenKart"));
        //testContextSetup.driver = new ChromeDriver();
        //testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    }
}
