package com.lemoney.support;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Utils {

	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			
			value = prop.getProperty(property);
			
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	
	public static AppiumDriver<?> returnDriver(String platform) throws Exception {
		AppiumDriver<?> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if (Boolean.parseBoolean(Utils.readProperty("run.hybrid"))) {
			capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
		}
		
		String completeURL = "http://" + Utils.readProperty("run.ip") + ":" + Utils.readProperty("run.port") + "/wd/hub";
		
		switch (platform.toLowerCase()) {
		
		case "ios":
			capabilities.setCapability(MobileCapabilityType.APP, new File(Utils.readProperty("app.ios.path")).getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Utils.readProperty("device.ios.name"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Utils.readProperty("platform.ios.version"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
			capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
			
			if ( Boolean.parseBoolean(Utils.readProperty("platform.ios.xcode8"))) {
				capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			}
			
			driver = new IOSDriver<RemoteWebElement>(new URL(completeURL), capabilities);
			break;

		case "android":
			
			capabilities.setCapability(MobileCapabilityType.APP, new File(Utils.readProperty("app.android.path")).getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Utils.readProperty("device.android.name"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
			
			driver = new AndroidDriver<RemoteWebElement>(new URL(completeURL), capabilities);
			break;
			
		default:
			throw new Exception("Platform not supported");
		}
		
		return driver;
	}
}
