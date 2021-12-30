package ecommerce.hooks;

import ecommerce.base.DriverFactory;
import ecommerce.base.TestContext;
import ecommerce.helpers.LoadConfigs;
import ecommerce.pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

/**
 * Hooks to use the @Before & @After hooks to execute before & after every scenario
 * @author Vijay
 * Dec 29, 2021
 */
public class Hooks {
    private WebDriver driver;
    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    /**
     * initialise the driver and set the driver & scenario to the TestContext(Executes before every scenario)
     * @param scenario
     * @author Vijay
     * Dec 29, 2021
     */
    @Before
    public void before(Scenario scenario) {
        driver = DriverFactory.initializeDriver(System.getProperty("browser",
                LoadConfigs.getInstance().getBrowser()));
        context.driver = driver;
        context.scenario = scenario;
    }

    /**
     * close the driver instance opened in the Before block and
     * attach the screenshot to the report for failed scenarios(Executes after every scenario)
     * @param scenario
     * @author Vijay
     * Dec 29, 2021
     */
    @After
    public void after(Scenario scenario) {
        if(scenario.isFailed())
            new BasePage(this.driver).captureScreenshotAndAttachToReport(scenario);
        this.driver.quit();
    }
}