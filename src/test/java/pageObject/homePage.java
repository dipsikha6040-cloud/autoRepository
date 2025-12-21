package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage {
    WebDriver driver ;
    public homePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("Driver is NULL. Hooks not executed.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[aria-label='Motoring']")
    private WebElement motoring;

    @FindBy(css="[data-cmp-id='submitButton']")
    private WebElement loginButton;

    @FindBy(css="input#loginPassword")
    private WebElement passwordField;

    @FindBy(css="input#loginEmail")
    private WebElement emailField;

    @FindBy(css="a[data-testid='account-link']")
    private WebElement accountIcon;

    @FindBy(css="button#onetrust-accept-btn-handler")
    private WebElement cookieClickCss;

    @FindBy(css="#dwfrm_vrnTyresWidgetForm_vrn")
    private  WebElement vrnField;

    @FindBy(css=".b-book-service__button.b-button__primary")
    private  WebElement findButton;



    public  void enterVrn() {
        vrnField.sendKeys("RV60LKP");
    }

    public  void clickOnFindButton() {
        findButton.click();
    }



    public  void clickOnMotoring() {
        motoring.click();
    }

    public void clickCookies() {
        waitForExpectedElement(cookieClickCss,20);
        cookieClickCss.click();

    }
    public void waitForExpectedElement(WebElement element,int seconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnAccountIcon() {
        waitForExpectedElement(accountIcon,30);
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

}
