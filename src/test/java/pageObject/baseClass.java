package pageObject;

import hook.hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class baseClass {
    protected WebDriver driver;

    public baseClass() {
        this.driver = hooks.driver;
        PageFactory.initElements(driver, this);
    }
}
