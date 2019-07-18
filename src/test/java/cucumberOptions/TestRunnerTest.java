package cucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"stepdefinitions"} )

public class TestRunnerTest extends AbstractTestNGCucumberTests {
}
