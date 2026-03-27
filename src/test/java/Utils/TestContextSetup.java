package Utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;
    public TestBase testbase;
    public GenericUtils genericUtils;



    public TestContextSetup() {
        this.testbase = new TestBase();
        this.driver = testbase.WebDriverManager();
        this.pageObjectManager = new PageObjectManager(driver);
        this.genericUtils = new GenericUtils(driver);

    }
}
