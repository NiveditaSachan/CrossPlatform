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

public class history {
    ExtentTest test;
    WebDriverWait wait;
    utilityClass util;

    String payToUser="Viddesh";

    @iOSFindBy(accessibility="History")
    @AndroidFindBy(id="le.money:id/home_history")
    public MobileElement history;

    @iOSFindBy(accessibility = "Successful")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='SUCCESSFUL']")
    public MobileElement successfulTab;

    @iOSFindBy(accessibility = "All")
    @AndroidFindBy(xpath="//android.widget.TextView[@text='ALL']")
    public MobileElement allTab;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'AUGUST 2018')]")
    public MobileElement currentMonthLabel;

    @iOSFindBy(accessibility = "Viddesh")
    @AndroidFindBy(id="le.money:id/user_name")
    public MobileElement userNameLatest;

    @iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Sent to\"])[1]")
    @AndroidFindBy(id="le.money:id/status_text")
    public MobileElement transactionStatusLatest;

    @iOSFindBy(accessibility = "21 Aug")
    @AndroidFindBy(id="le.money:id/transaction_time")
    public MobileElement transactionDate;

    @iOSFindBy (xpath = "(//XCUIElementTypeStaticText[@name=\"₹1\"])[1]")
    @AndroidFindBy(id="le.money:id/transaction_amount")
    public MobileElement transactionAmount;

    //Transaction details screen

    @AndroidFindBy(id="le.money:id/tr_status_text")
    public MobileElement trStatusInTrDetailsScreen;

    @AndroidFindBy(id="le.money:id/user_name")
    public MobileElement userNameInTrDetailsScreen;

    @AndroidFindBy(id="le.money:id/title_lm_id")
    public MobileElement lemIdTitleInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/lm_id")
    public MobileElement lemIdInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/title_card_type")
    public MobileElement cardTypeTitleInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/card_type")
    public MobileElement cardTypeInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/title_upi_id")
    public MobileElement cardpaymRefNoTitleInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/upi_id")
    public MobileElement cardpaymRefNoInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/deposit_title")
    public MobileElement depositTitleInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/deposit_details")
    public MobileElement depositdetailInTranDetailsScreen;

    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"le.money:id/title_date_time\"))")
  //  @AndroidFindBy(id="le.money:id/title_date_time")
    public MobileElement    timeTitleInTranDetailsScreen;

    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"le.money:id/tr_date_time\"))")
    public MobileElement timeInTranDetailsScreen;

    @AndroidFindBy(id="le.money:id/need_help")
    public MobileElement needHelpInTranDetailsScreen;

    @AndroidFindBy(uiAutomator="new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"lcom.google.android.gm:id/to\"))")
//    @AndroidFindBy(id="com.google.android.gm:id/to")
    public MobileElement toEmailId;

    @AndroidFindBy(id="com.google.android.gm:id/subject")
    public MobileElement subjectLine;

    public history(AppiumDriver driver, ExtentTest test) {
        PageFactory.initElements(new AppiumFieldDecorator (driver), this);
        this.test=test;
        wait=new WebDriverWait(driver, 10);
        util=new utilityClass(driver,test);

    }
}
