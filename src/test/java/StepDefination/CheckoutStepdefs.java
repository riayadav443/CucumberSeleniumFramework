package StepDefination;

import PageObjects.CheckoutPage;
import Utils.TestContextSetup;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckoutStepdefs {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutStepdefs(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }


    @When("Verify user has ability to enter promo code and place the order")
    public void verifyUserHasAbilityToEnterPromoCodeAndPlaceTheOrder() {
        Assert.assertTrue(checkoutPage.isPromoBtnPresent());
        Assert.assertTrue(checkoutPage.isPlaceOrderBtnPresent());
    }


    @When("User proceeds to Checkout and validate the {string} items in checkout page")
    public void userProceedsToCheckoutAndValidateTheItemsInCheckoutPage(String VegName) {

        checkoutPage.CheckoutItems();
        Assert.assertTrue(checkoutPage.getProductName().contains(VegName));
    }
}
