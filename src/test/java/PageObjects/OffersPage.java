package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//table/tbody/tr/td[1]");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String itemName){
        driver.findElement(search).sendKeys(itemName);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
