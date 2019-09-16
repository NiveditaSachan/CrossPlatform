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

public class ServicesMobilePrepaid {

    ExtentTest test;
    WebDriverWait wait;
    utilityClass util;

    @iOSFindBy(accessibility = "")
    @AndroidFindBy(id="")
    public MobileElement airtel;

    @iOSFindBy(accessibility = "")
    @AndroidFindBy(id="")
    public MobileElement airtelPrepaid;



    /*
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

    @iOSFindBy(accessibility = "")
    @AndroidFindBy(xpath="//android.widget.TextView[@text = 'Airtel']")
    public MobileElement airtelMobile;



    public ServicesMobilePrepaid(AppiumDriver driver, ExtentTest test){
        PageFactory.initElements(new AppiumFieldDecorator (driver), this);
        this.test=test;
        wait=new WebDriverWait(driver, 10);
        util=new utilityClass(driver,test);
    }

*/

}
