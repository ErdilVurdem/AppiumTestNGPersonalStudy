package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class ArabamAppTest {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest01() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
            assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
            assertTrue(driver.findElementByXPath("//*[@text='İlan ara']").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
            driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
            driver.findElementByXPath("//*[@text='Otomobil']").click();
            Thread.sleep(3000);

        // arac olarak Volkswagen secilir
           // TouchAction action=new TouchAction<>(driver);
           // action.press(PointOption.point(470,1570))
           //         .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
           //         .moveTo(PointOption.point(470,200))
           //         .release().perform();

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(10);"));
            driver.findElementByXPath("//*[@text='Volkswagen']").click();
            Thread.sleep(3000);

        // arac markasi olarak passat secilir
            driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
            driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();
        // Paket secimi yapilir
            driver.findElementByXPath("//*[@text='Highline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
            driver.findElementById("com.dogan.arabam:id/constraintLayoutSorting").click();
            driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
            Thread.sleep(1000);

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String enUcuzFiyatTL=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
        String enUcuzFiyat=enUcuzFiyatTL.replaceAll("\\D","");
        System.out.println(enUcuzFiyat);
        int enUcuzInt=Integer.parseInt(enUcuzFiyat);

        assertTrue(enUcuzInt>500000);

    }

}
