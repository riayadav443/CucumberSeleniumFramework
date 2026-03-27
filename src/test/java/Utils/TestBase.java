package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() {
        Properties prop = null;
        try {
            FileInputStream fis = new FileInputStream("src/test/Resources/Global.properties");
             prop = new Properties();
            prop.load(fis);
        }catch (IOException e){
            e.printStackTrace();
        }

        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven : browser_properties;

        if(driver == null){

            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            } else {
                driver = new EdgeDriver();
            }

        }
        driver.get(url);
        return driver;
    }
}
