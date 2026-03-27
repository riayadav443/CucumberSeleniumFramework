package StepDefination;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

//Single responsibility principle
//Loosly coupled
//Factory Design Pattern


public class OfferPageStepDefination {

    public String offerPageProductName;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;
    public OffersPage offersPage;
    public LandingPage landingPage;

    public OfferPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for same ShortName {string} in offers page to check if product exist")
    public void userSearchedForSameShortNameInOffersPageToCheckIfProductExist(String shortName) throws InterruptedException {

        switchToOffersPage();

        //pageObjectManager = new PageObjectManager(testContextSetup.driver);
        offersPage = testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(shortName);

        //testContextSetup.driver.findElement((By.xpath("//input[@type='search']"))).sendKeys(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
        //driver.switchTo().window(parentWindow);

        //driver.close(); // it will only close the child tab/ window
        // driver.quit();// To close all windows
    }

    public void switchToOffersPage(){
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        //if switched to offer page -> skip below part
        if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")){

        } else {
            landingPage.clickTopDeals();

            //testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
            testContextSetup.genericUtils.switchWindowsToChild();
        }
    }


    @And("Validate product name in offers page matches with landing page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);

    }
}

