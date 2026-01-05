package hook;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverManager;

public class hooks {
    @Before
    public void setUp() {
        DriverManager.getDriver();
    }
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}