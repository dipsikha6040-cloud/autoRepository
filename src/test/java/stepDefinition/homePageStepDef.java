package stepDefinition;

import hook.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.homePage;
import utils.getUserDataFromPropertyFile;
import utils.jsonReaderClass;

import java.io.IOException;
import java.util.Properties;

public class homePageStepDef {
    public static homePage home;
    static Properties prop;
    @Given("^the user lands on halfords homepage$")
    public void userlogsintohomepage()
    {
      home=new homePage(hooks.driver);// passing driver instance
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

}
