package ecommerce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * RunCucumberTest TestNG Runner
 *
 * @author Vijay
 * Dec 29, 2021
 */
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-report.json"},
        glue = {"ecommerce"},
        features = "src/test/resources/features"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}