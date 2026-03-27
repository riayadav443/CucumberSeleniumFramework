package cucumberOptions;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "@target/failed_scenarios.txt",
            glue = "StepDefination",
            monochrome = true,
            plugin = {"html:target/cucumber.html",
                    "json:target/cucumber.json",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",},
            dryRun = false)
    public class FailedTe {

//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios()
//        {
//            return super.scenarios();
//        }
    }


