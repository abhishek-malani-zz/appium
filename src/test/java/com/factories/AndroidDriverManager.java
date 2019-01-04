package com.factories;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class AndroidDriverManager {

	private DesiredCapabilities DesiredCapabilities;
	private AndroidDriver<WebElement> AndroidDriver;

	public AndroidDriver<WebElement> createAndroidDriver()
	{
		if(AndroidDriver==null)
		{
			createAndroidDriverInstance();
		}
		return AndroidDriver;
	}

	public void quitAndroidDriver()
	{
		if(AndroidDriver!=null)
		{
			AndroidDriver.quit();
			AndroidDriver= null;
		}
	}

	private void createAndroidDriverInstance()
	{
		AndroidDriver= null;
		createDesiredCapabilities();
		instantiateAndroidDriver();
	}
	
	private void createDesiredCapabilities()
	{
		DesiredCapabilities= new DesiredCapabilities();
		DesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK build for x86");
		DesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		DesiredCapabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		DesiredCapabilities.setCapability("debug", false);
		DesiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		DesiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		DesiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		DesiredCapabilities.setCapability("full-reset", true);
		DesiredCapabilities.setCapability("appPackage","com.android.calculator2");
		DesiredCapabilities.setCapability("appActivity",".Calculator");
		DesiredCapabilities.setCapability("newCommandTimeout", 120);
		DesiredCapabilities.setCapability("command-timeout", 120);
	}
	
	private void instantiateAndroidDriver()
	{
		try
		{
			AndroidDriver= new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), DesiredCapabilities);
		}
		catch(
				Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
