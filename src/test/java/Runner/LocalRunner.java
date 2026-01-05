package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featuresFile",
        glue = {"stepDefinition","hook"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
                //"devUser.json:target/cucumber.devUser.json"
        },
        monochrome = true,
        tags = "@dip3"
)
public class LocalRunner extends AbstractTestNGCucumberTests {
    // No code needed here
}
