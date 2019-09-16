package com.lemoney.ios;

import com.lemoney.po.MainScreenPageObject;
import com.lemoney.po.ServicesMobile;
import com.lemoney.support.utilityClass;
import com.lemoney.po.account;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.lemoney.po.history;
import java.util.List;

//import org.junit.Before;

public class lemoneyTestiOS{

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

        // Desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.UDID, "d6f2e45764244f64b18a49da5d14c81657ca2fb1");
        capabilities.setCapability("xcodeOrgId", "5C79GLKU9M");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/nivedita/Library/Developer/Xcode/DerivedData/Lemoney-ebodsqvvscsaifhbdyrvsdzotwdw/Build/Products/Debug-iphoneos/Lemoney-debug.app");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");


        capabilities.setCapability("useNewWDA", "true");
        capabilities.setCapability("waitForQuiescence", "false");


        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

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
     //   test=extentrep.startTest("iOS Automation Test Report ");

    }


    @AfterMethod
    // After each failure of @Test method this method will be executed
    public void getResult(ITestResult result) throws IOException{
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(LogStatus.FAIL, "Name of++++++ failed Test Case is '"+result.getName()+"'");
            test.log(LogStatus.FAIL, "Reason for Test Case Failure is - "+result.getThrowable());

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "test.addScreenCapture" method.
            String screenShotPath=  utilObj.captureScreenshot(result.getName(), driver);

            //To add it in the extent report
            test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));

        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        else if(result.getStatus ()==ITestResult.SUCCESS){
            test.log(LogStatus.INFO, "Name of passed Test Case is :'"+result.getName()+"'");

        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        //extentrep.endTest(test);

    }


	@AfterSuite()
	public void tearDown() {
		extentrep.endTest (test);
        extentrep.flush();
      //  extentrep.close();
		driver.quit();
	}


    @Test(priority=0)
    public void testLemoneyiOSHomePage() throws InterruptedException, IOException {
        test=extentrep.startTest("iOS Automation test Home Page");
        utilObj=new utilityClass(driver,test);
        homeScreenObj = new MainScreenPageObject(driver,test);
      //  mobileObj=new ServicesMobile(driver,test);

        test.log(LogStatus.PASS,"Passed");
        utilObj.enterText(homeScreenObj.lemoneyPin,"1234");
      //  utilObj.clickOnElement(homeScreenObj.Rs1Numpad,"Rs1");
     //   utilObj.swipeElement(homeScreenObj.swipeFrom,homeScreenObj.swipeTo);
     //   utilObj.clickOnElement(homeScreenObj.cancelLink);

    }

    @Test (dependsOnMethods="testLemoneyiOSHomePage")
    public void testLemoneyServiceScreen() throws IOException {
        mobileObj=new ServicesMobile(driver,test);
        extentrep.startTest ("Lemoney Service Screen");

        utilObj.clickOnElement(mobileObj.lemdirectory,"Directory");
        utilObj.clickOnElement(mobileObj.ServicesTab,"Services Tab");

        utilObj.verifyObjectDisplayed (mobileObj.mobileBiller);
        //utilObj.verifyObjectDisplayed (mobileObj.mobileLogo);

        //utilObj.verifyObjectDisplayed (mobileObj.landlineLogo);
        utilObj.verifyObjectDisplayed (mobileObj.landlineBiller);

        //utilObj.verifyObjectDisplayed (mobileObj.broadbandLogo);
        utilObj.verifyObjectDisplayed (mobileObj.broadbandBiller);

        //utilObj.verifyObjectDisplayed (mobileObj.dthLogo);
        utilObj.verifyObjectDisplayed (mobileObj.dthBiller);

        //utilObj.verifyObjectDisplayed (mobileObj.electricityLogo);
        utilObj.verifyObjectDisplayed (mobileObj.electricityBiller);

        //utilObj.verifyObjectDisplayed (mobileObj.insuranceLogo);
        utilObj.verifyObjectDisplayed (mobileObj.insuranceBiller);

        utilObj.clickOnElement(mobileObj.mobileBiller,"Mobile");
       // utilObj.clickOnElement(mobileObj.airtelMobile);
    }

    @Test (dependsOnMethods ={"testLemoneyiOSHomePage","testLemoneyServiceScreen"} )
    public void testLemoneyMobileScreen() throws IOException {

        extentrep.startTest ("Mobile Service Screen");

        //Verify the display of  Mobile billers- Label and logo
        utilObj.verifyObjectDisplayed (mobileObj.airtelMobile);
       // utilObj.verifyLogo (mobileObj.airtelMobile);
        utilObj.verifyObjectDisplayed (mobileObj.jioMobile);
       // utilObj.verifyLogo (mobileObj.jioMobile);
        utilObj.verifyObjectDisplayed (mobileObj.tataDocomoGSMMobile);
      //  utilObj.verifyLogo (mobileObj.tataDocomoGSMMobile);
        utilObj.verifyObjectDisplayed (mobileObj.vodafoneMobile);
       // utilObj.verifyLogo (mobileObj.vodafoneMobile);

        utilObj.clickOnElement (mobileObj.airtelMobile, "Airtel");
    }

    @Test (dependsOnMethods ={"testLemoneyiOSHomePage","testLemoneyServiceScreen","testLemoneyMobileScreen" })
    public void testMobileCommonBot() throws IOException, InterruptedException {

        extentrep.startTest ("Airtel Mobile Screen");
        utilObj.verifyTitleisEqualTo (mobileObj.billerFrameTitle,"Airtel");


        utilObj.verifyObjectDisplayed (mobileObj.billerFrameLogo);
        utilObj.verifyObjectDisplayed (mobileObj.billerFrameBackAndClose);

       driver.findElementByXPath ("//XCUIElementTypeStaticText[@name=\"TODAY\"]");
       // utilObj.verifyTitleisEqualTo (mobileObj.chatFrameDay,"TODAY");

        // Verify Welcome bot message and display text associated with it.
        utilObj.verifyObjectDisplayed (mobileObj.botMessageWelcomeIOS);
        utilObj.getText (mobileObj.botMessageWelcomeIOS);

        driver.findElementByXPath ("//XCUIElementTypeStaticText[@name=\"Before we begin, we need a few details from you. 1. Connection Type 2. Mobile Number 3. Circle\"]");
       // utilObj.verifyObjectDisplayed (mobileObj.botMessageDetailsNeededIOS);

        utilObj.clickOnElement (mobileObj.getStartedButton,"Get Started Button");

        // Bot message "Get Started"
        utilObj.verifyObjectDisplayed (mobileObj.getStartedBot);

        utilObj.verifyregexMatches (mobileObj.botMessageConnectionType,"What connection type is it?");
        utilObj.verifyObjectDisplayed (mobileObj.prepaidConnectionType);
        utilObj.verifyObjectDisplayed (mobileObj.postpaidConnectionType);
    }


    public void testSelectPrepaidMobile() throws IOException, InterruptedException {
        utilObj.clickOnElement (mobileObj.prepaidConnectionType,"Prepaid button");

        // Prepaid Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.prepaidConnectionType);

    }

    public void testSelectPostpaidMobile() throws IOException, InterruptedException {
        utilObj.clickOnElement (mobileObj.postpaidConnectionType,"Postpaid button");

        // Prepaid Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.postpaidConnectionType);

    }


    public void testMobileSelfNumberSelection() throws IOException, InterruptedException {
        utilObj.verifyObjectDisplayed(mobileObj.BotMessagePayingFor);


        utilObj.verifyObjectDisplayed (mobileObj.selfNumber);
        utilObj.verifyObjectDisplayed (mobileObj.otherNumber);

        utilObj.clickOnElement (mobileObj.selfNumber,"Self-9980921105");

        //Self-9980921105 Bot Message
        utilObj.verifyObjectDisplayed (mobileObj.selfNumber);
    }

    public void testMobileRegionOrCircleSelection() throws IOException, InterruptedException {
        utilObj.verifyregexMatches (mobileObj.botMessageWelcome.get (6),"your region/circle");
        utilObj.verifyObjectDisplayed (mobileObj.otherRegion);
        utilObj.verifyObjectDisplayed (mobileObj.currentState);
        utilObj.clickOnElement (mobileObj.currentState, "State -Karnataka ");

    }

    @Test
    public void testLemoneyProfile()throws IOException, InterruptedException {
        testLemoneyiOSHomePage ();

        acc = new account (driver, test);
        utilObj.clickOnElement (acc.userName, "User-Arun");
        utilObj.clickOnElement (acc.profileUserName, "Arun Kumar K H Profile");
        utilObj.tap (acc.shareImageEditProfile);
        utilObj.clickOnElement (acc.generateQRCodebutton, "Generate QR code button");
        // utilObj.verifyObjectDisplayed (acc.imgQRCode);
        // utilObj.verifyObjectDisplayed (acc.upiLogo);
        utilObj.verifyObjectDisplayed (acc.upiId);
        utilObj.clickOnElement (acc.doneButtonShareQRScreen, "Done button in share Your QR screen");

        // To add a 'DBS' Bank account linked with number
        if ( !acc.digibankCard.isDisplayed () ) {

            // Click on  (+) Add a card or a bank account in profile screen
            int size = utilObj.getSize (acc.addACardOrBankAcciOS);
            utilObj.tap (acc.addACardOrBankAcciOS.get (size - 1));
            utilObj.verifyObjectDisplayed (acc.addCardbutton);

            utilObj.clickOnElement (acc.addABankAccountbutton, "add a card or bank account");
            utilObj.enterText (acc.enterBankName, "DBS");
            utilObj.clickOnElement (acc.bankSearch, "DBS Bank");
            utilObj.verifyObjectDisplayed (acc.banklinkCard);
            utilObj.clickOnElement (acc.donebutton, "Done button");
        }

    }


        @Test
        public void testAirtelPrepaidMobile()throws IOException, InterruptedException{
        // Airtel Prepaid Mobile Biller
        testLemoneyiOSHomePage();
        testLemoneyServiceScreen();
        testLemoneyMobileScreen();
        testMobileCommonBot();
        testSelectPrepaidMobile();
        testMobileSelfNumberSelection();
        testMobileRegionOrCircleSelection();
    }

    @Test
    public void testHistory()throws IOException, InterruptedException {
        testLemoneyiOSHomePage ();
        hst=new history (driver,test);

        utilObj.clickOnElement (hst.history, "History Tab");
        utilObj.clickOnElement (hst.successfulTab, "Successful tab");
        utilObj.verifyObjectDisplayed (hst.currentMonthLabel);
        utilObj.verifyObjectDisplayed (hst.userNameLatest);
        utilObj.getText (hst.transactionStatusLatest);
        utilObj.getText (hst.userNameLatest);
        utilObj.getText (hst.transactionAmount);
        utilObj.getText (hst.transactionDate);

    }
}
