package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.*;

public class CalculatorTest {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void calculatorTest() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\VURDEM\\IdeaProjects\\AppiumPersonalStudy\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        assertTrue(driver.findElementById("com.google.android.calculator:id/parens").isDisplayed());

        driver.findElementByAccessibilityId("3").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("6").click();
        driver.findElementByAccessibilityId("equals").click();

        assertEquals(driver.findElementById("com.google.android.calculator:id/result_final").getText(),"3360");
        String sonuc=driver.findElementById("com.google.android.calculator:id/result_final").getText();
        assertEquals(Integer.parseInt(sonuc),3360);

    }
}
