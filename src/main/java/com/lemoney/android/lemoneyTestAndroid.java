package com.lemoney.android;

import com.lemoney.po.MainScreenPageObject;
import com.lemoney.po.ServicesMobile;
import com.lemoney.po.account;
import com.lemoney.po.history;
import com.lemoney.support.utilityClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.URL;

public class lemoneyTestAndroid {
    ITestResult result1=null;



    private AppiumDriver<MobileElement> driver;
    ExtentReports extentrep;
    ExtentTest test;
    utilityClass utilObj;
    MainScreenPageObject homeScreenObj;
    ServicesMobile mobileObj;
    account acc;
    history hst;
	
	@BeforeSuite
	public void setup() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/nivedita/Documents/Apps/lemoney/lemoney/app-debug.apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
		
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Make Extent report file
        // Load Extent Report config file

        File makedirFile = new File(System.getProperty("user.dir") + "/test-output");
        if (!makedirFile.exists()) {
            makedirFile.mkdir();
        }
        File file = new File(makedirFile.getPath() + "/Extentreport.html");
        if (!file.exists()) {
            file.createNewFile();

        }

        if(extentrep == null) {
            //Set HTML reporting file location

            extentrep = new ExtentReports(file.getPath(), true);
            extentrep
                    .addSystemInfo("Environment", "Cross -Platform Automation Testing")
                    .addSystemInfo("User Name", "Nivedita Singh");

        }
        extentrep.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
    //    test=extentrep.startTest("Android Automation test Report");
	}


    @AfterMethod
    // After each failure of @Test method this method will be executed
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Name of failed Test Case is '"+result.getName()+"'");
            test.log(LogStatus.FAIL, "Reason for Test Case Failure is - "+result.getThrowable());


            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "test.addScreenCapture" method.
            String screenShotPath=  utilObj.captureScreenshot(result.getName(), driver);

            //To add it in the extent report
           // util.captureScreenshot(result.getName(), driver);
           String abc= test.addScreenCapture(screenShotPath);
            test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));


        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        else if(result.getStatus ()==ITestResult.SUCCESS){
            test.log(LogStatus.INFO, "Name of passed Test Case is :'"+result.getName()+"'");

        }


        //extentrep.endTest (test);
    }

    @AfterSuite()
    public void tearDown() {
        extentrep.endTest (test);
        extentrep.flush();
//        extentrep.close();
        driver.quit();
    }
	
	@Test (priority=0)
	public void LemoneyAndroidHomePage() throws InterruptedException, IOException {
        test=extentrep.startTest("Android Automation test Home Page");
        utilObj=new utilityClass(driver,test);
        homeScreenObj = new MainScreenPageObject(driver,test);
        mobileObj=new ServicesMobile(driver,test);

        test.log(LogStatus.PASS,"Passed");
        utilObj.enterText(homeScreenObj.lemoneyPin,"1234");


    }

    @Test (dependsOnMethods="LemoneyAndroidHomePage")
    public void LemoneyServiceScreen() throws IOException {
        extentrep.startTest ("Lemoney Service Screen");
        utilObj.clickOnElement(homeScreenObj.Rs1Numpad,"Rs1");
        utilObj.swipeElement(homeScreenObj.swipeFrom,homeScreenObj.swipeTo);
        utilObj.clickOnElement(homeScreenObj.cancelLink,"Cancel Link");
        utilObj.clickOnElement(mobileObj.lemdirectory,"Directory");
      //  utilObj.clickOnElement(mobileObj.lemdirectory);
        utilObj.clickOnElement (mobileObj.ServicesTab,"Services Tab");

        utilObj.verifyLogo (mobileObj.mobileBiller);
        utilObj.verifyObjectDisplayed (mobileObj.mobileBiller);
        utilObj.verifyLogo (mobileObj.landlineBiller);
        utilObj.verifyObjectDisplayed (mobileObj.landlineBiller);
        utilObj.verifyLogo (mobileObj.broadbandBiller);
        utilObj.verifyObjectDisplayed (mobileObj.broadbandBiller);
        utilObj.verifyLogo (mobileObj.dthBiller);
        utilObj.verifyObjectDisplayed (mobileObj.dthBiller);
        utilObj.verifyLogo (mobileObj.electricityBiller);
        utilObj.verifyObjectDisplayed (mobileObj.electricityBiller);
        utilObj.verifyLogo (mobileObj.insuranceBiller);
        utilObj.verifyObjectDisplayed (mobileObj.insuranceBiller);
        utilObj.verifyLogo (mobileObj.gasBiller);
        utilObj.verifyObjectDisplayed (mobileObj.gasBiller);

        utilObj.clickOnElement (mobileObj.mobileBiller,"Mobile");
    }

    @Test (dependsOnMethods ={"LemoneyAndroidHomePage","LemoneyServiceScreen"} )
    public void LemoneyMobileScreen() throws IOException {

        extentrep.startTest ("Mobile Service Screen");

        //Verify the display of  Mobile billers- Label and logo
        utilObj.verifyObjectDisplayed (mobileObj.airtelMobile);
        utilObj.verifyLogo (mobileObj.airtelMobile);
        utilObj.verifyObjectDisplayed (mobileObj.jioMobile);
        utilObj.verifyLogo (mobileObj.jioMobile);
        utilObj.verifyObjectDisplayed (mobileObj.tataDocomoGSMMobile);
        utilObj.verifyLogo (mobileObj.tataDocomoGSMMobile);
        utilObj.verifyObjectDisplayed (mobileObj.vodafoneMobile);
        utilObj.verifyLogo (mobileObj.vodafoneMobile);

       utilObj.clickOnElement (mobileObj.airtelMobile, "Airtel");
     //   utilObj.clickOnElement (mobileObj.vodafoneMobile, "Vodafone");
    }


    @Test (dependsOnMethods ={"testLemoneyAndroidHomePage","testLemoneyServiceScreen","testLemoneyMobileScreen" })
    public void MobileCommonBot() throws IOException, InterruptedException {

        extentrep.startTest ("Airtel Mobile Screen");
        utilObj.verifyTitleisEqualTo (mobileObj.airtelMobile,"Airtel");


        utilObj.verifyObjectDisplayed (mobileObj.billerFrameLogo);
        utilObj.verifyObjectDisplayed (mobileObj.billerFrameBackAndClose);

        utilObj.verifyTitleisEqualTo (mobileObj.chatFrameDay,"TODAY");

        // Verify Welcome bot message and display text associated with it.
        utilObj.verifyObjectDisplayed (mobileObj.botMessageWelcome.get (0));
        utilObj.getText (mobileObj.botMessageWelcome.get (0));

        // Verify "Let's get Started...." bot message
        utilObj.verifyregexMatches (mobileObj.botMessageWelcome.get (1),"1. Connection Type \n" +
                "2. Mobile Number \n" +
                "3. Circle");
        utilObj.clickOnElement (mobileObj.getStartedButton,"Get Started Button");

        // Bot message "Get Started"
        utilObj.verifyObjectDisplayed (mobileObj.getStartedBot);

        utilObj.verifyregexMatches (mobileObj.botMessageConnectionType,"What connection type is it?");
        utilObj.verifyObjectDisplayed (mobileObj.prepaidConnectionType);
        utilObj.verifyObjectDisplayed (mobileObj.postpaidConnectionType);
    }


    public void SelectPrepaidMobile() throws IOException, InterruptedException {
        utilObj.clickOnElement (mobileObj.prepaidConnectionType,"Prepaid button");

        // Prepaid Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.prepaidConnectionType);

    }

    public void SelectPostpaidMobile() throws IOException, InterruptedException {
        utilObj.clickOnElement (mobileObj.postpaidConnectionType,"Postpaid button");

        // Prepaid Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.postpaidConnectionType);

    }


    public void MobileSelfNumberSelection() throws IOException, InterruptedException {
        utilObj.verifyObjectDisplayed(mobileObj.BotMessagePayingFor);


        utilObj.verifyObjectDisplayed (mobileObj.selfNumber);
        utilObj.verifyObjectDisplayed (mobileObj.otherNumber);

        utilObj.clickOnElement (mobileObj.selfNumber,"Self-9980921105");

        //Self-9980921105 Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.selfNumber);
    }

    public void mobileRegionOrCircleSelection() throws IOException, InterruptedException {
        utilObj.verifyregexMatches (mobileObj.botMessageWelcome.get (6),"your region/circle");
        utilObj.verifyObjectDisplayed (mobileObj.otherRegion);
        utilObj.verifyObjectDisplayed (mobileObj.currentState);
        utilObj.clickOnElement (mobileObj.currentState, "State -Karnataka ");

    }

    @Test
    public void testAirtelPrepaidMobile()throws IOException, InterruptedException{

        LemoneyAndroidHomePage();
        LemoneyServiceScreen();
        LemoneyMobileScreen();
        MobileCommonBot();
        SelectPrepaidMobile();
        MobileSelfNumberSelection();
        mobileRegionOrCircleSelection();
    }

    @Test
    public void testLemoneyProfileScreen()throws IOException, InterruptedException{
        LemoneyAndroidHomePage ();
        Thread.sleep (5000);
        acc = new account (driver, test);

        WebDriverWait wait = new WebDriverWait(driver, 40);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("hi");


        int x=acc.userName.getCenter ().getX ();
        int y=acc.userName.getCenter ().getY ();
        utilObj.tap (acc.userName);
        acc.userName.click ();
        //utilObj.clickOnElement (acc.userName,"Account-Nivedita");

        utilObj.clickOnElement (acc.profileUserName, "Nivedita Sachan Profile");
        utilObj.tap (acc.shareImageEditProfile);
        utilObj.clickOnElement (acc.generateQRCodebutton, "Generate QR code button");
        utilObj.verifyObjectDisplayed (acc.imgQRCode);
        utilObj.verifyObjectDisplayed (acc.upiId);
        utilObj.clickOnElement (acc.doneButtonShareQRScreen, "Done button in share Your QR screen");
        utilObj.clickOnElement (acc.backArrowEditProfile, "Back Arrow");

        utilObj.clickOnElement (acc.addACardOrBankAcc,"Add Another bank");
        utilObj.clickOnElement (acc.addABankAccountbutton,"Add a bank account button");
        utilObj.clickOnElement (acc.enterBankName, "Bank search");

        utilObj.clickOnElement (acc.searchImage,"Search Image");
        utilObj.enterText (acc.enterBankName,"ICICI");
        utilObj.clickOnElement (acc.bankSearch,"Click on Bank");
        Thread.sleep (5000);
        utilObj.clickOnElement (acc.banklinkCard, "Bank Link Card");
        utilObj.clickOnElement (acc.donebutton, "Done button");
    }

    @Test
    public void testHistory()throws IOException, InterruptedException {
        LemoneyAndroidHomePage ();
        hst=new history (driver,test);
        Thread.sleep (5000);
        utilObj.tap (hst.history);
        utilObj.clickOnElement (hst.successfulTab, "Successful tab");
        utilObj.verifyObjectDisplayed (hst.userNameLatest);
        utilObj.getText (hst.transactionStatusLatest);
        utilObj.getText (hst.userNameLatest);
        utilObj.getText (hst.transactionAmount);
        utilObj.getText (hst.transactionDate);
        utilObj.clickOnElement (hst.userNameLatest, "Latest Transaction History");

        // Transaction details Screen
        utilObj.verifyObjectDisplayed (hst.trStatusInTrDetailsScreen);
        utilObj.getText (hst.userNameInTrDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.lemIdTitleInTranDetailsScreen);
        utilObj.getText (hst.lemIdInTranDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.cardTypeTitleInTranDetailsScreen);
        utilObj.getText (hst.cardTypeInTranDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.cardpaymRefNoTitleInTranDetailsScreen);
        utilObj.getText (hst.cardpaymRefNoInTranDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.depositTitleInTranDetailsScreen);
        utilObj.getText (hst.depositdetailInTranDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.timeTitleInTranDetailsScreen);
        utilObj.getText (hst.timeInTranDetailsScreen);
        utilObj.verifyObjectDisplayed (hst.needHelpInTranDetailsScreen);

        // Click on Need Help

       /*
        utilObj.clickOnElement (hst.needHelpInTranDetailsScreen,"Need Help in Transaction detail");
        utilObj.getText (hst.toEmailId);
        utilObj.getText (hst.subjectLine);
*/
    }


    }
