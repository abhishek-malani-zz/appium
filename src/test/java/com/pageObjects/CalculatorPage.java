package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.util.webElement.WebElementActions;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorPage

extends PageObject
{
	
	@FindBy(id= "com.android.calculator2:id/digit_1")
	private WebElement Digit1Button;
	
	@FindBy(id= "com.android.calculator2:id/op_add")
	private WebElement PlusSignButton;
	
	@FindBy(id= "com.android.calculator2:id/eq")
	private WebElement EqualsSignButton;
	
	@FindBy(id= "com.android.calculator2:id/result")
	private WebElement EquationTextField;

	public CalculatorPage(AndroidDriver<WebElement> androidDriver)
	{
		super(androidDriver);
	}

	public String calculateResultForEquation1Plus1()
	{
		return clickDigit1Button().clickPlusSignButton().clickDigit1Button().clickEqualsSignButton().getEquationTextFieldText();
	}

	private CalculatorPage clickDigit1Button()
	{
		WebElementActions.click(Digit1Button);
		return this;
	}

	private CalculatorPage clickPlusSignButton()
	{
		WebElementActions.click(PlusSignButton);
		return this;
	}

	private CalculatorPage clickEqualsSignButton()
	{
		WebElementActions.click(EqualsSignButton);
		return this;
	}

	private String getEquationTextFieldText()
	{
		return WebElementActions.getText(EquationTextField);
	}
}
