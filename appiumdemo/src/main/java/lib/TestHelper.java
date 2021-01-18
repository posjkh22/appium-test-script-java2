package lib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestHelper {
	
	public static MobileElement findElementById(AppiumDriver<MobileElement> driver, String id) {		
		return (MobileElement) driver.findElement(By.xpath("//*[@resource-id='" + id + "']"));
	}
	
	public static String getHtmlText(AppiumDriver<MobileElement> driver, String id) {
		return ((MobileElement) findElementById(driver, id)).getText();
	}
	
	
	
	public static MobileElement findElementByClassName(AppiumDriver<MobileElement> driver, String id) {		
		return (MobileElement) driver.findElementByClassName(id);
	}
	
	public static String getHtmlTextByClassName(AppiumDriver<MobileElement> driver, String id) {
		return ((MobileElement) findElementByClassName(driver, id)).getText();
	}
	
	
	/*
	public static MobileElement findElementByCssSelector(AppiumDriver<MobileElement> driver, String id) {		
		return (MobileElement) driver.findElement(By.cssSelector("//*[atsid='" + id + "']"));
	}
	
	public static String getHtmlTextByCssSelector(AppiumDriver<MobileElement> driver, String id) {
		return ((MobileElement) findElementByCssSelector(driver, id)).getText();
	}
	*/
	
	public static List<MobileElement> findElementsById(AppiumDriver<MobileElement> driver, String id) {		
		return (List<MobileElement>) driver.findElements(By.xpath("//*[contains(@resource-id, '" + id + "')]"));
	}
	
	public static List<String> getHTmlTextList(AppiumDriver<MobileElement> driver, String id) {
		
		List<MobileElement> elements = (List<MobileElement>) findElementsById(driver, id);
		List<String> texts = new ArrayList<String>();
		
		System.out.println(" -> size: " + elements.size());
		
		for (int i=0; i<elements.size(); i++){
				texts.add(((MobileElement) elements.get(i)).getText());
		}
		return texts;
	}
	
	public static List<MobileElement> findElementsByClassName(AppiumDriver<MobileElement> driver, String id) {		
		return (List<MobileElement>) driver.findElements(By.xpath("//*[contains(class, '" + id + "')]"));
	}
	
	public static List<String> getHTmlTextListByClassName(AppiumDriver<MobileElement> driver, String id) {
		
		List<MobileElement> elements = (List<MobileElement>) findElementsByClassName(driver, id);
		List<String> texts = new ArrayList<String>();
		
		System.out.println(" -> size: " + elements.size());
		
		for (int i=0; i<elements.size(); i++){
				texts.add(((MobileElement) elements.get(i)).getText());
		}
		return texts;
	}
	
	
	// https://github.com/saikrishna321/VodQaAdvancedAppium/blob/master/src/test/java/com/appium/gesture/GestureTest.java
	public static void SingleTap(AppiumDriver<MobileElement> driver, String id) {
		/*
		Actions actions = new Actions(driver);
		actions.click((MobileElement) findElementById(driver, id));
		actions.perform();
		*/
		
		//TouchAction action = new TouchAction(driver);
		//action.tap((MobileElement) findElementById(driver, id));
		//action.perform();
	}
	
	/*
	public void backKey(AppiumDriver<MobileElement> driver) {
		driver.back();
	}
	*/
	
	// https://itnext.io/three-ways-to-how-to-capture-screenshots-with-selenium-webdriver-47358a5cd2fb
	public static void ScreenShot(AppiumDriver<MobileElement> driver) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("d:\\tmp\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
