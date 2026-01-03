package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class clp extends baseClass{
    public clp(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "[data-testid='product-tile'] a.halfords-link-standard")
    private List<WebElement> selectFirstProduct;
    public void userSelectsFirstProduct(String sku) {
        selectFirstProduct.stream().filter(e -> e.getAttribute("href").contains(sku)).findFirst().ifPresent(WebElement::click);

    }

}
