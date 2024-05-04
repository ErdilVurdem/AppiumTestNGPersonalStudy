package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements(Driver.getAndroidDriver(),this);
    }

    @FindBy (xpath = "(//*[@class='android.widget.Button'])[4]")
    public WebElement ContiueAsAGuest;

    @FindBy (xpath = "(//*[@class='android.view.View'])[5]")
    public WebElement oneWayReturnButton;

    @FindBy (xpath = "//*[@content-desc='Clear All']")
    public WebElement sehirSecmeCarpiButonu;




}
