package com.Tutorials.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailAdressField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailPasswordNomatchWarning;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	public AccountPage clickLoginButton() {
		loginButton.click();
		return new AccountPage(driver);

	}
	
	public AccountPage logIn(String emailText,String passwordText) {
		emailAdressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
		
	}

	public String retrieveEmailPasswordNotMatchingWarningMassageText() {

		String warningText = emailPasswordNomatchWarning.getText();
		return warningText;

	}
	
	

}
