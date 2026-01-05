package stepDefinition;

import hook.hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.homePage;
import utils.getUserDataFromPropertyFile;
import utils.jsonReaderClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class homePageStepDef {
    private final homePage home;
    private  Properties prop;
    public homePageStepDef(homePage home)
    {
        this.home=home;//this-->refers to current instance variable
    }

    @Given("^the user lands on halfords homepage$")
    public void userlogsintohomepage()
    {
      home.openingUrl();
    }

    @And("^user enter vrn postcode on motoring page$")
    public void enterVrnPostcode()
    {
        home.enterVrn();
        home.clickOnFindButton();
    }


    @And("^the user click on motoring on the global header menu$")
    public void theUserClickOnMotoringOnTheGlobalHeaderMenu() {
        home.clickOnMotoring();
    }

    @And("^the user click on accept all cookie$")
    public void theUserClickOnAcceptAllCookie() {
        home.clickCookies();
    }

    @And("^user click on Account icon$")
    public void userClickOnAccountIcon() {
        home.clickOnAccountIcon();
    }

    @And("^user enter email and password in the log pop up$")
    public void userEnterEmailAndPasswordInTheLogPopUp() throws IOException {
        System.out.println(jsonReaderClass.getUserData().getUsername());
        System.out.println(jsonReaderClass.getUserData().getPassword());
        prop= getUserDataFromPropertyFile.loadProperties();
        System.out.println(prop.getProperty("hwd"));
        System.out.println(prop.getProperty("cnc"));
        System.out.println(prop.getProperty("postcode"));
        System.out.println(prop.getProperty("vrn"));


        home.enterEmail(jsonReaderClass.getUserData().getUsername());
        home.enterPassword(jsonReaderClass.getUserData().getPassword());
    }

    @And("^user click on log in button$")
    public void userClickOnLogInButton() {
        home.clickOnLogin();
    }

    @And("^the user searches for the sku$")
    public void theUserSearchesForTheSku() throws IOException {
        prop= getUserDataFromPropertyFile.loadProperties();
        String sku=prop.getProperty("cnc");

        home.searchSku(sku);

    }



    @And("the user waits for the page to load")
    public void theUserWaitsForThePageToLoad() {
        home.waitForPageLoad(50);

    }

    @And("^the user enter postcode (.*) on pdp$")
    public void theUserEnterPostcodeOnPdp(String p1) {
        home.enterPostCode(p1);
    }

    @When("^the click on choose a collection day button$")
    public void theClickOnChooseACollectionDayButton() {
        home.clickOnChooseACollectionDayButton();

    }


    @And("^the user navigates the hirearchy menu$")
    public void theUserNavigatesTheHirearchyMenu(DataTable dataTable) {
        Map<String, String> hierarchy = dataTable.asMaps().get(0);
        String tier1 = hierarchy.get("Tier1");
        String tier2 = hierarchy.get("Tier2");
        String tier3 = hierarchy.get("Tier3");
        String tier4 = hierarchy.get("Tier4");
        if (isEmpty(tier1)) {
            throw new IllegalArgumentException("Tier1 is mandatory");
        }
        if (isEmpty(tier2)) {
            System.out.println(tier1);
//            clickMenu(tier1);
        }
        else if (isEmpty(tier3)) {
//            hoverMenu(tier1);
//            clickMenu(tier2);
            System.out.println(tier1);
            System.out.println(tier2);
        }
        else if (isEmpty(tier4)) {
//            hoverMenu(tier1);
//            hoverMenu(tier2);
//            clickMenu(tier3);
            System.out.println(tier1);
            System.out.println(tier2);
            System.out.println(tier3);
        }
        else {
//            hoverMenu(tier1);
//            hoverMenu(tier2);
//            hoverMenu(tier3);
//            clickMenu(tier4);
            System.out.println(tier1);
            System.out.println(tier2);
            System.out.println(tier3);
            System.out.println(tier4);
        }
    }
    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

}
}
