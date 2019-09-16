package com.lemoney.po;

import com.lemoney.support.utilityClass;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class account {

    ExtentTest test;
    WebDriverWait wait;
    utilityClass util;


    @iOSFindBy(accessibility="Arun")
    @AndroidFindBy(id="le.money:id/home_profile")
  //  @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"le.money:id/home_profile\")")
    public MobileElement userName;

    @iOSFindBy(accessibility="Arun Kumar K H")
    @AndroidFindBy(id="le.money:id/profileUserName")
    public MobileElement profileUserName;

    @iOSFindBy(accessibility = "9663976507")
    @AndroidFindBy(id="le.money:id/profile_num")
    public MobileElement mobileNumber;

  //  @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]")
    @AndroidFindBy(id="le.money:id/addAnotherAccount")
    public MobileElement addACardOrBankAcc;

    @iOSFindBy(xpath="(//XCUIElementTypeImage[@name=\"trust_vibe\"])")
    public List<MobileElement> addACardOrBankAcciOS;

  //  @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add a bank account\"]")
    @iOSFindBy(accessibility = "Add a bank account")
    @AndroidFindBy(id="le.money:id/add_bank")
    public MobileElement addABankAccountbutton;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add a card\"]")
    @AndroidFindBy(id="le.money:id/add_card")
    public MobileElement addCardbutton;

    @iOSFindBy (xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeSheet/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement cancelLink;

    @AndroidFindBy(id = "le.money:id/search_image")
    public MobileElement searchImage;

   // @iOSFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Enter bank name\"]")
    @iOSFindBy(accessibility = "Enter bank name")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Pick your bank']")
    public MobileElement enterBankName;

    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ICICI Bank']")
    public MobileElement bankSearch;

    @iOSFindBy(xpath = "//XCUIElementTypeImage[@name=\"trust_vibe\"]")
    @AndroidFindBy(id="le.money:id/a_card_lay")
    public MobileElement banklinkCard;

    @iOSFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
    @AndroidFindBy(id="le.money:id/done_button")
    public MobileElement donebutton;

    @iOSFindBy(accessibility = "Digibank by DBS")
    public MobileElement digibankCard;

    @iOSFindBy(accessibility = "Share_blue")
    @AndroidFindBy(id="le.money:id/share_image")
    public MobileElement shareImageEditProfile;

    @iOSFindBy(accessibility = "Generate QR code")
    @AndroidFindBy(id="le.money:id/generate_qr")
    public MobileElement generateQRCodebutton;

    @iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"Lemoney\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage[1]")
    @AndroidFindBy(id="le.money:id/qr_code_image")
    public MobileElement imgQRCode;

    @iOSFindBy(accessibility = "QR_upi_logo")
    public MobileElement upiLogo;

    @iOSFindBy(accessibility = "lemoney.751184404@yesbank")
    @AndroidFindBy(id="le.money:id/vpa_text")
    public MobileElement upiId;

    @iOSFindBy(accessibility = "Done")
    @AndroidFindBy(id="le.money:id/done_button")
    public MobileElement doneButtonShareQRScreen;

    @iOSFindBy (accessibility = "back arrow")
    @AndroidFindBy(id="le.money:id/backAndClose")
    public MobileElement backArrowEditProfile;

    public account(AppiumDriver driver, ExtentTest test) {
        PageFactory.initElements(new AppiumFieldDecorator (driver), this);
        this.test=test;
        wait=new WebDriverWait(driver, 10);
        util=new utilityClass(driver,test);

    }

}
