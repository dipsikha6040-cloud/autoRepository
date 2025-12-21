package stepDefinition;

import hook.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObject.homePage;
import utils.jsonReaderClass;

import java.io.IOException;

public class homePageStepDef {
    homePage home;
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
        home.enterEmail(jsonReaderClass.getUserData().getUsername());
        home.enterPassword(jsonReaderClass.getUserData().getPassword());
    }

    @And("user click on log in button")
    public void userClickOnLogInButton() {
        home.clickOnLogin();
    }
}
