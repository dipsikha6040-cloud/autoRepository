package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class pdp extends baseClass {
    public pdp(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(css = ".f-radio-secondary__item .f-radio-secondary__label .f-radio-secondary__text")
    private List<WebElement> WouldYouLikeItBuilt;

    @FindBy(css="[data-cmp='addToCart'][data-cmp-id='addToCartBooking']")
    private WebElement bookSelectedAppointmentCta;

    @FindBy(css=".b-booking__time-group--morning .b-booking__time-group-label")
    private WebElement morningTimeSlot;

    @FindBy(css=".b-booking__time-group--morning .b-booking__time-group-item button[data-cmp='bookingSlotButton']")
    private WebElement morningTimeSlotsList;

    @FindBy(css=".b-booking__time-group--afternoon .b-booking__time-group-item button[data-cmp='bookingSlotButton']")
    private WebElement afternoonTimeSlot;

    @FindBy(css=".b-booking__time-group--afternoon .b-booking__time-group-item button[data-cmp='bookingSlotButton']")
    private WebElement afternoonTimeSlotList;

    @FindBy(css=".b-booking__time-group--afternoon .b-booking__time-group-item button[data-cmp='bookingSlotButton']")
    private WebElement eveningTimeSlotList;

    public void clickOnWouldYouLikeItBuilt(String fitting) {

        scrollIntoView(WouldYouLikeItBuilt.get(0));
        WebElement radioButton = WouldYouLikeItBuilt.stream()
                .filter(e -> e.getText().trim().equalsIgnoreCase(fitting))
                .findFirst().orElseThrow(() -> new RuntimeException("Option not found"));
        clickUsingJS(radioButton);

    }

    public void bookSelectedAppointment() {
        clickUsingJS(bookSelectedAppointmentCta);
    }

    public void selectTimeSlot(String userInput) {
      if(morningTimeSlot.getText().toLowerCase().contains(userInput))
      {
          morningTimeSlotsList.click();
      }
      else if(afternoonTimeSlot.getText().toLowerCase().contains(userInput))
      {
         afternoonTimeSlotList.click();
      }
      else
      {
          eveningTimeSlotList.click();
      }
    }
}
