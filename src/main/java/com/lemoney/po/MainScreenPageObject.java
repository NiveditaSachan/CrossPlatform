package com.lemoney.po;

import java.util.concurrent.TimeUnit;

import com.lemoney.support.utilityClass;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainScreenPageObject<xpath> {

	ExtentTest test;
	WebDriverWait wait;
	utilityClass util;


	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
	@AndroidFindBy(id="le.money:id/pin_1")
	public  MobileElement lemoneyPin;

	//@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeButton")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeButton")
	@AndroidFindBy(id="le.money:id/button1")
	public MobileElement Rs1Numpad;

	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
	@AndroidFindBy(id="le.money:id/seekBar2")
	public MobileElement swipeFrom;

	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"GET\"]")
	@AndroidFindBy(id="le.money:id/getE")
//	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"E\"))")
	public MobileElement swipeTo;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[9]/XCUIElementTypeOther/XCUIElementTypeButton")
	@AndroidFindBy(id="le.money:id/cancel_text")
	public MobileElement cancelLink;



	public MainScreenPageObject(AppiumDriver driver, ExtentTest test) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.test=test;
		wait=new WebDriverWait(driver, 10);
		util=new utilityClass(driver,test);

	}
	
}
