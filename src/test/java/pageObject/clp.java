package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class clp extends baseClass{
    public clp()
    {
        super();//difference between super and super(),
        //super-->it is a reversed keyword in java which is used to refer variable in a parent class
        //super()-->used to call the constructor of a parent class
    }


    @FindBy(css = "[data-testid='product-tile'] a.halfords-link-standard")
    private List<WebElement> selectFirstProduct;
    public void userSelectsFirstProduct(String sku) {
        selectFirstProduct.stream().filter(e -> e.getAttribute("href").contains(sku)).findFirst().ifPresent(WebElement::click);

    }

}
