package com.cucumber.authframeworkAndroid;


import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static Process process;
	private static String APPIUMSERVERSTART = "node /usr/local/bin/appium";

	private static AndroidDriver driver;
	String appId = "com.gtech.liquidsportsbook.mgmqa";

	@Before
	public void localSetUp() throws IOException, InterruptedException {

		//stopAppiumServer();
		//startAppiumServer();
		setDriver(Env.driver_setUp());

	}

	public static AndroidDriver getDriver() {
		return driver;
	}

	public static void setDriver(AndroidDriver driver) {
		Hooks.driver = driver;
	}

	public static void startAppiumServer() throws IOException,
			InterruptedException {
		// Runtime.getRuntime().exec("killall node");
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec(APPIUMSERVERSTART);
		Thread.sleep(60000);
		if (process != null) {
			System.out.println("Appium server started");
			Thread.sleep(1000);
		} else {
			System.out.println("appium server taking longer to re-start");
		}
	}

	public static void stopAppiumServer() throws IOException,
			InterruptedException {
		if (process != null) {
			process.destroy();
		}
		System.out.println("Appium server stop");
		Thread.sleep(5000);
	}

	public static void startAppium() throws Exception {

		CommandLine command = new CommandLine("/usr/local/bin/node"); // /Applications/Appium.app/Contents/Resources/node/bin/node
		command.addArgument(
				"/usr/local/lib/node_modules/appium/build/lib/main.js", false); // /Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js
		command.addArgument("--address");
		command.addArgument("0.0.0.0");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset", true); // //Avoid resetting the app
													// betweeen sessions
		command.addArgument("--log-level");
		command.addArgument("info");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		Thread.sleep(5000);
	}

	public static void stopAppium(Scenario scenario) throws IOException {
		Runtime.getRuntime().exec("killall node");
	}

	@After
	public void closebrowser(Scenario scenario) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = dateFormat.format(cal.getTime());
		
		
		try {
			
			getDriver().quit();	
			System.out.println("End Of Scenario: " + dateStr + " " 
					+ scenario.getName());
		} catch (Exception e) {
			
		}

	}
}
