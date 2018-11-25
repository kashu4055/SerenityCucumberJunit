package com.walmart.cucumber.steps.serenity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumUser {
	
	AppiumDriver driver;
	
	@Step
	public void setup() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "testDevice");
		capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		capabilities.setCapability("platformVersion", "8");
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		// capabilities.setCapability("recreateChromeDriverSessions", true);
		// capabilities.setCapability("chromedriverExecutable","/usr/local/bin/chromedriver");
		File file = new File("/Users/dmp001j/Downloads", "Inventoryandroid-debug.apk");
		capabilities.setCapability("app", file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	
	@Step
	public void enterCredentials(){


		System.out.println("Test method Started");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement userIdTextField = (MobileElement) driver
				.findElement(By.id("com.walmart.auth.app:id/useridlayout"));
		userIdTextField.sendKeys("sysadmin");
		MobileElement passwordTextField = (MobileElement) driver
				.findElement(By.id("com.walmart.auth.app:id/passwordlayout"));
		passwordTextField.sendKeys("MMNext13#");
		
		driver.hideKeyboard();
		
	}

	
	@Step
	public void sigIn() {
		
		MobileElement signInButton = (MobileElement) driver.findElement(By.id("com.walmart.auth.app:id/sign_in"));
		signInButton.click();
		
	}


}
