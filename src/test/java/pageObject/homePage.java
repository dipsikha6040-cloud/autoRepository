package pageObject;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class homePage extends baseClass {
    public homePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "[aria-label='Motoring']")
    private WebElement motoring;

    @FindBy(css = "[data-cmp='addToCart'][data-cmp-id='addToCartBooking']")
    private WebElement selectAppointmentButton;

    @FindBy(css = ".flatpickr-calendar span.flatpickr-day")
    private List<WebElement> dayFromCalender;

    @FindBy(css = ".b-booking .b-booking__time .b-booking__time-group [data-cmp='bookingSlotButton']")
    private List<WebElement> timeSlotFromCalendar;

    @FindBy(css = "[data-cmp-id='viewCalendar'].b-button__success")
    private WebElement chooseACollectionDayButton;

    @FindBy(css = ".f-input__group .localities-input-wrapper .localities-input-container .js-postcode[placeholder='Postcode or location']")
    private WebElement postCodeField;

    @FindBy(css = ".localities-container li.localities-item")
    private List<WebElement> postCodeSuggestion;



    @FindBy(css = "[data-cmp-id='submitButton']")
    private WebElement loginButton;

    @FindBy(css = "input#loginPassword")
    private WebElement passwordField;

    @FindBy(css = "input#search-suggestions")
    private WebElement searchfield;

    @FindBy(css = "input#loginEmail")
    private WebElement emailField;

    @FindBy(css = "a[data-testid='account-link']")
    private WebElement accountIcon;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement cookieClickCss;

    @FindBy(css = "#dwfrm_vrnTyresWidgetForm_vrn")
    private WebElement vrnField;

    @FindBy(css = ".b-book-service__button.b-button__primary")
    private WebElement findButton;

    @FindBy(css = "[data-testid='halfords-icon-button'][aria-label^='Search product']")
    private WebElement searchIconButton;


    public void enterVrn() {
        vrnField.sendKeys("RV60LKP");
    }

    public void clickOnFindButton() {
        findButton.click();
    }


    public void clickOnMotoring() {
        motoring.click();
    }

    public void clickCookies() {
        waitForExpectedElement(cookieClickCss, 20);
        cookieClickCss.click();

    }
    public void clickOnAccountIcon() {
        waitForExpectedElement(accountIcon, 30);
        accountIcon.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void searchSku(String sku) {
        searchfield.sendKeys(sku);
        searchIconButton.click();
    }

    public void enterPostCode(String postcode) {
        postCodeField.sendKeys(postcode);
        waitForPageLoad(10);
        postCodeSuggestion.stream().filter(e -> e.getText()
                .trim().equalsIgnoreCase(postcode)).findFirst().ifPresent(WebElement::click);
    }

    public void clickOnChooseACollectionDayButton() {
        if(chooseACollectionDayButton.isDisplayed()) {
            clickUsingJS(chooseACollectionDayButton);
            dayFromCalender.stream()
                    .filter(e->!e.getAttribute("class")
                            .contains("disabled")).

                    findFirst().ifPresent(WebElement::click);

        }


//        clickUsingJS(dayFromCalender.get(0));
//        clickUsingJS(timeSlotFromCalendar.get(0));
//        selectAppointmentButton.click();


    }
}

