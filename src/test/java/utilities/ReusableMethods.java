package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
      static AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    public static void koordinatTiklamaMethodu(int x,int y) throws InterruptedException {
        TouchAction action=new TouchAction(driver);
        action.press(PointOption.point(x,y)).release().perform();
        Thread.sleep(1000);
    }

    public static void texteTiklamaMethodu(String text){
        String xpath="//*[@text='"+text+"']";
        driver.findElementByXPath(xpath).click();
    }

    public static WebElement texteIleBulmaMethodu(String text){
        String xpath="//*[@text='"+text+"']";
        WebElement element=driver.findElementByXPath(xpath);
        return element;
    }
}
