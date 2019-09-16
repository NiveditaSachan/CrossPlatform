package com.lemoney.support;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import org.testng.Assert;
//import sun.font.TrueTypeFont;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class utilityClass {
    AppiumDriver driver;
    ExtentTest test;
    WebDriverWait wait;
    TouchAction t;


    public utilityClass(AppiumDriver driver, ExtentTest test){
        this.driver=driver;
        this.test=test;
        wait=new WebDriverWait(driver, 20);
    }

    public String captureScreenshot(String fileName, AppiumDriver<MobileElement> driver) throws IOException {
        File makedirFile = new File(System.getProperty("user.dir") + "/Screenshot");
        if (!makedirFile.exists()) {
            makedirFile.mkdir();
        }

        String destPath;
        String screenShotPath;
        try{
            File file=((TakesScreenshot)(this.driver)).getScreenshotAs(OutputType.FILE);

             destPath=makedirFile.getPath()+"/Screenshot_"+fileName+ ".png";
             File destFile=new File(destPath);

            // targetFile = new File(makedirFile.getPath()+"/Screenshot_", fileName+ ".jpg");
           // FileUtils.copyFile(file,new File( destPath));
            FileUtils.copyFile(file,destFile);



        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage() + " Exception in capture screenshot");
        }
        return destPath;

    }

    public void enterText(MobileElement tBoxElement, String text) throws IOException {
        try {
            if ( wait.until (visibilityOf(tBoxElement)).isDisplayed ()) {

                tBoxElement.sendKeys(text);
                test.log(LogStatus.PASS, "text: " + text + " is entered successfully in mobile element, element.getText()= " + tBoxElement.toString());
            } else {
                test.log(LogStatus.FAIL, "Mobile Element: " + tBoxElement + " is  not found in wait time of  10 seconds" + test.addScreenCapture(captureScreenshot(tBoxElement.toString(),driver)));
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "text: " + text + " is  not entered in element, element.getText()= " + tBoxElement.toString()  +test.addScreenCapture(captureScreenshot(tBoxElement.toString(),driver)));
            throw new RuntimeException(e.getMessage() + " Element is not visible");


        }
    }

    public void verifyObjectDisplayed(MobileElement ObjectName) throws IOException {
        try {
            wait.until(visibilityOf(ObjectName)).isDisplayed();
            test.log(LogStatus.PASS, ObjectName.getAttribute("name") + " is displayed");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, ObjectName.getAttribute("name") + " is  not found" + test.addScreenCapture(captureScreenshot(ObjectName.getAttribute("name"),driver)));
            throw new RuntimeException(e.getMessage() + "Element is not visible");
        }
    }


    public void clickOnElement(MobileElement elementToClick, String elementName) throws IOException {
        try {
           if (wait.until(visibilityOf(elementToClick)).isDisplayed()){
            Thread.sleep (1000);
                elementToClick.click();
            test.log(LogStatus.PASS, elementName+" is Clicked");
                 }

        else  {
                test.log(LogStatus.FAIL,  elementName + " is not found in wait time 10 sec"+  test.addScreenCapture(captureScreenshot(elementName,driver)));
                 }
        }
        catch (Exception e) {
            test.log(LogStatus.FAIL,  elementName + " is not Clicked "+  test.addScreenCapture(captureScreenshot(elementName,driver)));
            throw new RuntimeException(e.getMessage() + "Element is not clicked");
        }

    }

    public void swipeElement(MobileElement fromElement, MobileElement toElement) throws IOException {
        TouchAction t=new TouchAction(driver);
       try{
           if(wait.until(visibilityOf(fromElement)).isDisplayed()) {
               t.press(fromElement).waitAction().moveTo(toElement).release().perform();
           }
           else {
               test.log(LogStatus.FAIL, "Element " + fromElement.getAttribute("name") + " is not found in wait time 10 sec"+  test.addScreenCapture(captureScreenshot(fromElement.getAttribute("name"),driver)));
           }
       }
       catch (Exception e){
           test.log(LogStatus.FAIL, "Element " + fromElement.getAttribute("name") + " is not swiped "+  test.addScreenCapture(captureScreenshot(fromElement.getAttribute("name"),driver)));
           throw new RuntimeException(e.getMessage() + "Element is not clicked");

       }
    }

    public MobileElement getPrecedingSibling(MobileElement element,String classNameOfPrecedingSibling){
        MobileElement precedingSibling = null;
        try{
            if(wait.until (visibilityOf (element)).isDisplayed ()){
                String precedingSiblingxpath;
                precedingSiblingxpath="//"+ element.getTagName ()+"/preceding-sibling::"+classNameOfPrecedingSibling;
                //      /following-sibling::
                precedingSibling= (MobileElement) driver.findElementByXPath (precedingSiblingxpath);

            }
            else {
                test.log(LogStatus.FAIL, "Element " + element.toString () + " is not found in wait time 10 sec"+  test.addScreenCapture(captureScreenshot(element.toString (),driver)));

            }

        }
        catch(Exception e){
            throw new RuntimeException (e.getMessage ()+ "Preceding Sibling of Element  "+element+"is not found ");
        }
        return precedingSibling;
    }


    public void verifyLogo(MobileElement element){
       try {
           String classNameOfLogo="android.widget.ImageView";
            getPrecedingSibling (element, classNameOfLogo).isDisplayed ();
       }
       catch (Exception e){
           throw new RuntimeException (e.getMessage ()+ "Logo of Preceding Sibling of Element  "+element+"is not found ");

       }
    }

    public void verifyTitleisEqualTo(MobileElement element, String match) throws IOException {
        try {
            //  //XCUIElementTypeApplication[@name="Lemoney"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton
            verifyObjectDisplayed (element);
           if(element.getText ().equalsIgnoreCase (match)){
               test.log (LogStatus.PASS,"Title of "+element.getText ()+" matches with "+match);
           }
           else {
               test.log (LogStatus.FAIL,"Title of "+element.getText ()+" does not matches with "+match);

           }
        }
        catch (Exception e){
           test.log (LogStatus.FAIL,"Element "+element+" not found or exception in element.getText() method : "+element.getText ());

        }
    }

    public void getText(MobileElement element) throws IOException {
        verifyObjectDisplayed (element);
        try {
           test.log (LogStatus.PASS,"Text displayed by getText method of element is : \"" + element.getText ()+ "\"");

        }
        catch (Exception e){
            test.log (LogStatus.FAIL, "Text is not displayed by 'getText()' method for element " + element);
            throw new RuntimeException (e.getMessage () + "Text is not displayed by 'getText()' method for element " + element);

        }
    }
    public void verifyregexMatches(MobileElement element, String match) throws IOException {
        verifyObjectDisplayed (element);
        try {
            element.getText ().matches (match);
            test.log (LogStatus.PASS,"Regex matched,Text displayed is : \"" + element.getText ()+ "\"");

        }
        catch (Exception e){
            test.log (LogStatus.FAIL, "Text is not displayed or regex did not match by 'getText()' method for element " + element);
            throw new RuntimeException (e.getMessage () + "Text is not displayed by 'getText()' method for element " + element);

        }
    }

    public int getSize(List<MobileElement> element){
        element.size ();
        return element.size ();
    }

    private int getXcoordinate(MobileElement e) throws InterruptedException {
        int x= e.getCenter ().getX ();
        return x;

    }

    private int getYcoordinate(MobileElement e){
        int y= e.getCenter ().getY ();
        return y;

    }

    public void tap(MobileElement e) throws InterruptedException {
        t=new TouchAction (driver);
        int x=getXcoordinate (e);
        int y=getYcoordinate (e);
        t.tap (x,y).release ().perform ();
    }

    public void ScrollDown(MobileElement e) throws InterruptedException {
        t=new TouchAction (driver);
    }

    }
