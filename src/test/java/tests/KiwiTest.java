package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

import static org.testng.AssertJUnit.*;
import static utilities.ReusableMethods.*;

public class KiwiTest {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    KiwiPage kiwiPage=new KiwiPage();

    @Test
    public void KiwiTest() throws InterruptedException {
// uygulamanin yuklendigi dogrulanir
       driver.isAppInstalled("com.skypicker.main");
// uygulamanin basariyla acildigi dogrulanir
        assertTrue(kiwiPage.ContiueAsAGuest.isDisplayed());
// misafir olarak devam et e tiklanir
        kiwiPage.ContiueAsAGuest.click();
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i <3 ; i++) {
            Thread.sleep(1000);
            ReusableMethods.koordinatTiklamaMethodu(500,1700);
        }
// Trip type,one way olarak secilir
    //kiwiPage.oneWayReturnButton.click();
        texteTiklamaMethodu("Return");
        Thread.sleep(1000);
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    texteTiklamaMethodu("One way");
    texteTiklamaMethodu("From:");
    Thread.sleep(1000);
    kiwiPage.sehirSecmeCarpiButonu.click();
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    driver.getKeyboard().sendKeys("Adana");

    if (texteIleBulmaMethodu("Adana, Turkey").isDisplayed()){
        texteTiklamaMethodu("Adana, Turkey");
    }else {
        System.out.println("Adanayı bulamadı haberin olsun!!!");
    }
    texteTiklamaMethodu("Choose");

// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        texteTiklamaMethodu("To:");
        driver.getKeyboard().sendKeys("istanbul");

        if (texteIleBulmaMethodu("Istanbul, Turkey").isDisplayed()){
            texteTiklamaMethodu("Istanbul, Turkey");
        }else {
            System.out.println("İstanbulu bulamadı haberin olsun!!!");
        }
        texteTiklamaMethodu("Choose");
// gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        texteTiklamaMethodu("Departure:");
        Thread.sleep(1000);
        TouchAction action=new TouchAction<>(driver);
        for (int i = 0; i <3 ; i++) {
            action.press(PointOption.point(530,1300))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(530,200))
                    .release().perform();
            Thread.sleep(1000);
        }

        koordinatTiklamaMethodu(970,830);
        Thread.sleep(1000);
        texteTiklamaMethodu("Set date");
        Thread.sleep(1000);

        // search butonuna tiklanir
        //kiwiPage.searchButton.click();
        koordinatTiklamaMethodu(550,1200);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        texteTiklamaMethodu("Best");
        texteTiklamaMethodu("Cheapest");
        Thread.sleep(1000);
        texteTiklamaMethodu("Stops");
        texteTiklamaMethodu("Nonstop");
        Thread.sleep(1000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String biletFiyati=kiwiPage.fiyatText.getText();
        driver.sendSMS("+90888888888","Bulunan en ucuz bilet fiyatı "+biletFiyati);

    }




}
