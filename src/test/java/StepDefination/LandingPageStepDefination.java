package StepDefination;

import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class LandingPageStepDefination {


    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;
    LandingPage landingPage;

    public LandingPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @When("User searched with Shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

        //pageObjectManager = new PageObjectManager(testContextSetup.driver);
        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);

        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        Thread.sleep(3000);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='product-name'])[1]")));


        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName +" is extracted from Home page");


    }


    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        landingPage.addItemsToCart(Integer.parseInt(quantity));
    }
}
