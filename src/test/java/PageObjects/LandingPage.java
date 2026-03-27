package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("(//*[@class='product-name'])[1]");
    By topDeals = By.linkText("Top Deals");
    By incrementBtn = By.xpath("//a[@class='increment']");
    By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");

    public LandingPage(WebDriver driver) {

        this.driver = driver;
    }

    public void searchItem(String itemName){
        driver.findElement(search).sendKeys(itemName);
    }

    public String getProductName(){
       return driver.findElement(productName).getText();
    }

    public void clickTopDeals(){
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void addItemsToCart(int quantity){
        for(int i = 1; i< quantity; i++){
           driver.findElement(incrementBtn).click();
        }
        driver.findElement(addToCartBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
