package stepDefinition;

import hook.hooks;
import io.cucumber.java.en.And;
import pageObject.clp;
import utils.getUserDataFromPropertyFile;

import java.io.IOException;
import java.util.Properties;

public class clpStepDef {
    clp clpPage=new clp(hooks.driver);
    private Properties prop;

    @And("^user select the first product from clp page$")
    public void userSelectTheFirstProductFromClpPage() throws IOException {
        prop= getUserDataFromPropertyFile.loadProperties();
        String sku=prop.getProperty("cnc");
        clpPage.userSelectsFirstProduct(sku);
    }
}
