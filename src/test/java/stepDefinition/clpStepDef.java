package stepDefinition;

import hook.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObject.clp;
import utils.getUserDataFromPropertyFile;

import java.io.IOException;
import java.util.Properties;

public class clpStepDef {
    private final clp clpPage;

    public clpStepDef(clp clpPage) {
        this.clpPage = clpPage;
    }
    private Properties prop;

    @And("^user select the first product from clp page$")
    public void userSelectTheFirstProductFromClpPage() throws IOException {
        prop= getUserDataFromPropertyFile.loadProperties();
        String sku=prop.getProperty("cnc");
        clpPage.userSelectsFirstProduct(sku);
    }


}
