package com.testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.factories.AndroidDriverManager;
import com.factories.AndroidDriverManagerFactory;
import com.pageObjects.CalculatorPage;
import com.util.misc.string.StringContent;
import io.appium.java_client.android.AndroidDriver;

/*
 * Before running the test case the Appium server and the mobile device must be up and running and be connected.
 */

public class CalculateEquationResultTestCase
{
    private String ExpectedEquationResult= "2";
    private String ComputedEquationResult;
    private AndroidDriverManagerFactory AndroidDriverManagerFactory;
    private AndroidDriverManager AndroidDriverManager;
    private AndroidDriver<WebElement> AndroidDriver;

    public CalculateEquationResultTestCase()
    {
    	AndroidDriverManagerFactory = new AndroidDriverManagerFactory();
        AndroidDriverManager = new AndroidDriverManager();
    }

    @BeforeMethod
	public void beforeMethod()
	{
		AndroidDriverManager = AndroidDriverManagerFactory.createAndroidDriverManager();
    	if(AndroidDriverManager!=null)
    	{
    		AndroidDriver = AndroidDriverManager.createAndroidDriver();
    	}
    }

    @AfterMethod
	public void afterMethod()
    {
    	if(AndroidDriverManager!=null)
    	{
    		AndroidDriverManager.quitAndroidDriver();
    	}
    }

	@Test()
	public void testCalculateResultOfEquation()
	{
		ComputedEquationResult= new CalculatorPage(AndroidDriver).calculateResultForEquation1Plus1();
		Assert.assertTrue(isComputedEquationResultEqualToExpectedEquationResult(), "Expected result: " + ExpectedEquationResult +
				"\n" + "Computed result: " + ComputedEquationResult);
	}

    private boolean isComputedEquationResultEqualToExpectedEquationResult()
    {
    	boolean isComputedEquationResultEqualToExpectedEquationResult = false;
		if(ComputedEquationResult!=null)
		{
			isComputedEquationResultEqualToExpectedEquationResult= StringContent.isString1EqualToString2IgnoreCase(ComputedEquationResult, ExpectedEquationResult);
		}

		return isComputedEquationResultEqualToExpectedEquationResult;
    }
}
