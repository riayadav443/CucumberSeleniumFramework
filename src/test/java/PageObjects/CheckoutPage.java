package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    By cartBtn = By.xpath("//img[@alt='Cart']");
    By checkoutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By applyBtn = By.xpath("//*[@class='promoBtn']");
    By placeOrderBtn = By.xpath("//*[text()='Place Order']");
    By productName = By.xpath("//*[@class='product-name']");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void CheckoutItems(){
        driver.findElement(cartBtn).click();
        driver.findElement(checkoutBtn).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPromoBtnPresent(){
       return driver.findElement(applyBtn).isDisplayed();

    }
    public boolean isPlaceOrderBtnPresent(){
        return driver.findElement(placeOrderBtn).isDisplayed();

    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
