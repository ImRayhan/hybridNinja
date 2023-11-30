package com.Tutorials.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {
	WebDriver driver;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement accountSuccessPageHeading;

	public AccountSucessPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retrieveAccountSuccessPageHeading() {
		String retrieveAccountSuccessPageHeading = accountSuccessPageHeading.getText();
		return retrieveAccountSuccessPageHeading;

	}

}
