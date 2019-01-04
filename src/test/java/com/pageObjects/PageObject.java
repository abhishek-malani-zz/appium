package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

abstract class PageObject
{
	private AndroidDriver<WebElement> AndroidDriver;
	protected PageObject(AndroidDriver<WebElement> androidDriver)
	{
		if(androidDriver==null)
		{
			throw new RuntimeException("AndroidDriver instance is NULL");
		}
		AndroidDriver = androidDriver;
		PageFactory.initElements(AndroidDriver,this);
	}
}
