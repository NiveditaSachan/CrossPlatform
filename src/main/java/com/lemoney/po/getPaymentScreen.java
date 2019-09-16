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

public class getPaymentScreen {

    ExtentTest test;
    WebDriverWait wait;
    utilityClass util;

    @AndroidFindBy(id="le.money:id/contacts_icon")
    @iOSFindBy(xpath="")
    public MobileElement lemGetContacts;

    public MobileElement cancelLink;

    public getPaymentScreen(AppiumDriver driver, ExtentTest test) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.test=test;
        wait=new WebDriverWait(driver, 10);
        util=new utilityClass(driver,test);

    }

}
