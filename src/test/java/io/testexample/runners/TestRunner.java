package io.testexample.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.testexample.environmentconfig.FrameworkConfig;
import io.testexample.utils.JavaUtils;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(plugin = {"pretty",
        "html:target/htmlReports/cucumber.html",
        "json:target/jsonReports/cucumber.json",
        "junit:target/xmlReport/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
        features="src/test/resources/features",
        glue = "io/testexample/stepDefs",
        tags = "",
        dryRun = false,
        publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
    @Parameters("baseURI")
    @BeforeClass
    public void setUp(){

    }
}
