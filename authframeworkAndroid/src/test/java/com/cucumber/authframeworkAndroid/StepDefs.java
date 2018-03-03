package com.cucumber.authframeworkAndroid;

import org.junit.Assert;
import io.appium.java_client.android.AndroidDriver;

import com.cucumber.authframeworkAndroid.AuthHomePage;
import com.cucumber.authframeworkAndroid.Hooks;

import cucumber.api.java.en.Given;

public class StepDefs {

	static String pin;
	String verificationcode;

	AndroidDriver wd = Hooks.getDriver();
	AuthHomePage hp = new AuthHomePage(wd);
	

	/**************** HOME PAGE *********************/

	@Given("^I am on Home page$")
	public void i_am_on_Home_page() throws Throwable {

		String text = hp.homPageMessage(wd);

		System.out.println(text);

		Assert.assertEquals("playMGM brings the best sports betting experience to your smartphone.", text);

	}

	@Given("^I select Let's Go button$")
	public void i_select_Let_s_Go_button() throws Throwable {

		hp.letsGoButton();
	}
}