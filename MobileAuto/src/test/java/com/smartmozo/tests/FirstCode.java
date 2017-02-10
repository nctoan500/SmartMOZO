package com.smartmozo.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstCode {
	/* 
	 * PRE CONDITION
	 * Enable Wifi + Bluetooth
	 * Welcome already
	 */
	
	private static AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "cca223a6d8c5");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage","mozo.o2o.biglabs.com.smartmozo");
		capabilities.setCapability("appActivity","mozo.o2o.biglabs.com.smartmozo.activity.LauncherActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");
	}

	@AfterTest 
	public void End() { 
		driver.quit(); 
	}
	
	@Test(priority = 1)
	public void LaunchAPP() throws Exception {
		driver.findElementsByXPath("//android.widget.TabWidget/android.widget.LinearLayout").get(4).click();
	}
}
