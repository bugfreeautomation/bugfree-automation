package com.cucumber.authframeworkAndroid;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import cucumber.api.java.After;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Env {

	public static AndroidDriver driver;

	public static AndroidDriver driver_setUp() throws IOException, InterruptedException {

		String appPath = "/Users/sakshi/Desktop/jenkins-qa-apps/QA_playMGM_1.10_(158).apk";
		File app = new File(appPath);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.main.MainActivity");
		capabilities.setCapability("appWaitActivity", "com.gtech.liquidsportsbook.intro.IntroActivity");
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.login.LoginActivity");
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.splash.SplashActivity");
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.requestnewpin.RequestNewPinActivity");
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.resetpin.ResetPinActivity");
		capabilities.setCapability("app-activity", "com.gtech.liquidsportsbook.terms.TermsActivity");

		capabilities.setCapability("maxTypingFrequency", 7);

		capabilities.setCapability("noReset", false);

		capabilities.setCapability("appium-version", "1.7.2");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("deviceName", "QA");
		capabilities.setCapability("platformVersion", "7.0");

		capabilities.setCapability("udid", "ce081718e3a33e1705");
		capabilities.setCapability("automationName", "uiautomator2");

		capabilities.setCapability("showXcodeLog", "true");
		capabilities.setCapability("app", app.getAbsolutePath());

		capabilities.setCapability("sendKeyStrategy", "grouped");
		capabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/deviceconsole");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		capabilities.setCapability("newCommandTimeout", "60");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void Quit() {

		driver.closeApp();
		driver.quit();

	}
}
