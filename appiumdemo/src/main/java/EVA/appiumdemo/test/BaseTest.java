package EVA.appiumdemo.test;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
 
public class BaseTest {
 
    
	AppiumDriver<MobileElement> driver = null;
	String PLATFORM_NAME = "ANDROID";
	String PLATFORM_VERSION = "9";
	String AUTOMATION_NAME = ("IOS".equals(PLATFORM_NAME)) ? "XCUITest" : "uiautomator2";
	
    @Before
    public void setup()
    {
        try
        {
            DesiredCapabilities caps= new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,PLATFORM_VERSION);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"adv_9");
            caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
            //caps.setCapability(MobileCapabilityType.APP, "D:\\webApp\\cordova\\hello\\platforms\\android\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
            caps.setCapability(MobileCapabilityType.APP, "D:\\webApp\\cordova\\hello\\platforms\\AppiumNativeTest\\app\\build\\outputs\\apk\\debug\\app-debug.apk");

            //caps.setCapability("appPackage","com.example.helloapp");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
            //caps.setCapability("appActivity","MainActivity");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");           
            
        	if ("IOS".equals(PLATFORM_NAME)) {
                driver = new IOSDriver<MobileElement>(url,caps);
        	} else {
                driver = new AndroidDriver<MobileElement>(url,caps);
        	}
            
            
            System.out.println("setup()");
            
        }catch(Exception exp)
        {
            System.out.println("exception()");
        }
    }
     
      
    @After
    public void teardown()
    {
        System.out.println("teardown()");
    }
}