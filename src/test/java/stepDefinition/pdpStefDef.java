package stepDefinition;

import hook.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.pdp;

public class pdpStefDef {
    pdp pdpPage=new pdp(hooks.driver);

    @And("^user click on (.*) on pdp$")
    public void userClickOnDontBuildMyBikeOnPdp(String fitting_position) throws InterruptedException {
        pdpPage.clickOnWouldYouLikeItBuilt(fitting_position);
        Thread.sleep(600);

    }

    @Then("^the user click on book selected appointment$")
    public void theUserClickOnBookSelectedAppointment() {
        pdpPage.bookSelectedAppointment();
    }

    @And("^the user selects a (.*) timeslot from the calender$")
    public void theUserSelectsATimeslotFromTheCalender(String slot) {
        pdpPage.selectTimeSlot(slot);
    }
}
