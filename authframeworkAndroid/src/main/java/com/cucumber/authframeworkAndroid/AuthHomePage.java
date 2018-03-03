package com.cucumber.authframeworkAndroid;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AuthHomePage {

	protected final AndroidDriver driver;

	public AuthHomePage(AndroidDriver wd) {
		this.driver = wd;
		PageFactory.initElements(wd, this);
	}


	@FindBy(id = "com.gtech.liquidsportsbook.mgmqa:id/logoImageView")
	private WebElement logoImageView;
	
	@FindBy(id = "com.gtech.liquidsportsbook.mgmqa:id/textView")
	private WebElement textView;

	@FindBy(id = "com.gtech.liquidsportsbook.mgmqa:id/letsGoButton")
	private WebElement letsGoButton;

	public String homPageMessage(AndroidDriver wd) {

		WebDriverWait wait = new WebDriverWait(wd, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("logoImageView")));

		logoImageView.isDisplayed();
		String text = textView.getText();
		
		return text;

	}
	
	public void letsGoButton() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("letsGoButton")));

		letsGoButton.click();
		
	}
}
