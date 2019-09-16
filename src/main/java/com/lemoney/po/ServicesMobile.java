package com.lemoney.po;

import com.lemoney.support.utilityClass;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ServicesMobile {
    ExtentTest test;
    WebDriverWait wait;
    utilityClass util;

    @AndroidFindBy(id="le.money:id/home_directory")
    @iOSFindBy(accessibility="Directory")
    public MobileElement lemdirectory;

    // @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    //	@iOSFindBy(xpath="//XCUIElementTypeStaticText[@name=\"1\"]")
    //@AndroidFindBy(xpath="//a[contains(text(),'Continue using')]") not working


    @iOSFindBy(accessibility = "Services")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='SERVICES']")
    public MobileElement ServicesTab;

    @iOSFindBy(accessibility = "Mobile")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Mobile']")
    public MobileElement mobileBiller;

    @iOSFindBy(xpath="//XCUIElementTypeImage[@name=\"ic_mobile\"]")
    public MobileElement mobileLogo;

    @iOSFindBy(accessibility = "Landline")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Landline']")
    public MobileElement landlineBiller;

    @iOSFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_landline\"]")
    public MobileElement landlineLogo;

    @iOSFindBy(accessibility = "Broadband")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Broadband']")
    public MobileElement broadbandBiller;

    @iOSFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_broadband\"]")
    public MobileElement broadbandLogo;

    @iOSFindBy(accessibility = "DTH")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'DTH']")
    public MobileElement dthBiller;

    @iOSFindBy(xpath = "//XCUIElementTypeImage[@name=\"ic_dth\"]")
    public MobileElement dthLogo;

    @iOSFindBy(accessibility = "Electricity")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Electricity']")
    public MobileElement electricityBiller;

    @iOSFindBy(accessibility = "//XCUIElementTypeImage[@name=\"ic_electricity\"]")
    public MobileElement electricityLogo;

    @iOSFindBy(accessibility = "Insurance")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Insurance']")
    public MobileElement insuranceBiller;

    @iOSFindBy(accessibility = "//XCUIElementTypeImage[@name=\"ic_insurance\"]")
    public MobileElement insuranceLogo;

    @iOSFindBy(accessibility = "Gas")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Gas']")
    public MobileElement gasBiller;


    @iOSFindBy(accessibility = "Airtel")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Airtel']")
    public MobileElement airtelMobile;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeImage")
    public MobileElement airtelLogo;

    @iOSFindBy(accessibility = "Jio")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Jio']")
    public MobileElement jioMobile;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeImage")
    public MobileElement jioLogo;

    @iOSFindBy(accessibility = "Tata Docomo GSM")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Tata Docomo GSM']")
    public MobileElement tataDocomoGSMMobile;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeImage")
    public MobileElement tataDocomoGSMLogo;

    @iOSFindBy(accessibility = "Vodafone")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Vodafone']")
    public MobileElement vodafoneMobile;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeImage")
    public MobileElement vodafoneLogo;


    // Biller Frame Screen
    @iOSFindBy(xpath="//XCUIElementTypeOther[@name=\"Airtel\"]")
    @AndroidFindBy(id="le.money:id/toolBarTitle")
    public MobileElement billerFrameTitle;

    @iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name=\"Airtel\"]/XCUIElementTypeButton[2]")
    @AndroidFindBy(id="le.money:id/profile_image")
    public MobileElement billerFrameLogo;

    @iOSFindBy(accessibility = "back arrow")
    @AndroidFindBy(id="le.money:id/backAndClose")
    public MobileElement billerFrameBackAndClose;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TODAY\"]")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='TODAY']")
    public MobileElement chatFrameDay;

    @AndroidFindBy(id="le.money:id/messagee")
    public List<MobileElement> botMessageWelcome;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement botMessageWelcomeIOS;


    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"To get started, we need a few details. 1. Connection Type 2. Mobile Number 3. Circle\"]")
    public MobileElement botMessageDetailsNeededIOS;

    public String classLetsGetStarted="android.widget.TextView";

    @iOSFindBy(accessibility = "Get Started")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Get Started']")
    public MobileElement getStartedButton;

    @iOSFindBy(accessibility = "Get Started")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Get Started']")
    public MobileElement getStartedBot;

    @iOSFindBy(accessibility = "What connection type is it?")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='What connection type is it?']")
    public MobileElement botMessageConnectionType;

    @iOSFindBy(accessibility = "Prepaid")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Prepaid']")
    public MobileElement prepaidConnectionType;

    @iOSFindBy(accessibility = "Postpaid")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Postpaid']")
    public MobileElement postpaidConnectionType;

    @iOSFindBy(accessibility = "Who will you be paying for?")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Who will you be paying for?']")
    public MobileElement BotMessagePayingFor;

    @iOSFindBy(accessibility = "Self - 9663976507")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Self-919980921105']")
    public MobileElement selfNumber;

    @iOSFindBy(accessibility = "Other")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Other']")
    public MobileElement otherNumber;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Please provide your region/circle']")
    public MobileElement BotMessageRegionOrCircle;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Other']")
    public MobileElement otherRegion;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Karnataka']")
    public MobileElement currentState;



    /*
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE, iOSAutomation = ALL_POSSIBLE)
    @FindAll({@FindBy(someStrategy1), @FindBy(someStrategy2)})
    @AndroidFindBy(someStrategy1) @AndroidFindBy(someStrategy2)
    @iOSFindBy(someStrategy1) @iOSFindBy(someStrategy2)
    List<RemoteWebElement> someElements;
*/

    public ServicesMobile(AppiumDriver driver, ExtentTest test){
        PageFactory.initElements(new AppiumFieldDecorator (driver), this);
        this.test=test;
        wait=new WebDriverWait(driver, 10);
        util=new utilityClass(driver,test);
    }


}
