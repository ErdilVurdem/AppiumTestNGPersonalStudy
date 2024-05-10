package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;

public class AllCurrencyTest {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyPage allCurrencyPage=new AllCurrencyPage();

    @Test
    public void allCurrencyTest(){
        // all currency uygulamasinin yuklendigi dogulanir
        driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter");
        // uygulamanin acildigi dogrulanir
        allCurrencyPage.currencyConverterText.isDisplayed();
        // cevirmek istedigimiz para birimi zloty olarak secilir
        allCurrencyPage.cevrilenParaBirimi.click();


        // cevrilen tutar screenShot olarak kaydedilir



        //  ReusableMethods.getScreenshot("plnToZlotyNew");

// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
// kullaniciya sms olarak bildirilir

    }

}
