package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyPage {
    public AllCurrencyPage(){
        PageFactory.initElements(Driver.getAndroidDriver(),this);
    }

    @FindBy (xpath = "(//*[@class='android.widget.TextView'])[1]")
    public WebElement currencyConverterText;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyA")
    public WebElement cevrilenParaBirimi;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB")
    public WebElement cevirilecekParaBirimi;
}
