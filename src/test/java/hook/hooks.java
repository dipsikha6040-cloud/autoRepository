package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://storefront:half0rds@dev.halfords.com/");

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
            File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination=new File("target/screenshot"+scenario.getName()+".png");
            FileUtils.copyFile(src,destination);
        }
        driver.quit();
    }


}