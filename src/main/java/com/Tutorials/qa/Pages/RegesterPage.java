package com.Tutorials.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegesterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement passworconfirmdField;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicycheckboxField;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@type='radio' and @name='newsletter'][@value='1']")
	private WebElement yesNewsLatterOption;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailAdressWarning;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telePhoneWarning;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;

	public RegesterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String retrievePrivacyPolicyWarning() {
		String retrievePrivacyPolicyWarning = privacyPolicyWarning.getText();
		return retrievePrivacyPolicyWarning;

	}

	public String retrievefirstNameWarning() {
		String retrievefirstNameWarning = firstNameWarning.getText();
		return retrievefirstNameWarning;

	}

	public String retrieveLastNameWarning() {
		String retrieveLastNameWarning = lastNameWarning.getText();
		return retrieveLastNameWarning;

	}

	public String retrieveEmailWarning() {
		String retrieveEmailWarning = emailWarning.getText();
		return retrieveEmailWarning;

	}

	public String retrieveTelePhoneWarning() {
		String retrieveTelePhoneWarning = telePhoneWarning.getText();
		return retrieveTelePhoneWarning;

	}

	public String retrievePasswordWarning() {
		String retrievePasswordWarning = passwordWarning.getText();
		return retrievePasswordWarning;

	}

	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);

	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);

	}

	public void enterEmailAdress(String emailText) {
		emailField.sendKeys(emailText);

	}

	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);

	}

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);

	}

	public void enterConfirmPassword(String ConfirmPasswordText) {
		passworconfirmdField.sendKeys(ConfirmPasswordText);

	}

	public void selectPrivacyPolicy() {
		privacyPolicycheckboxField.click();

	}

	public AccountSucessPage clickContinueButton() {
		continueButton.click();
		return new AccountSucessPage(driver);

	}


	public String retrieveDuplicateEmailAdressWarning() {
		String duplicateEmailWarning = duplicateEmailAdressWarning.getText();
		return duplicateEmailWarning;
	}
	
	public AccountSucessPage regesterWithmandatoryField(String firstNameText,String lastNameText,String emailText,String telphoneText,String passwordText,String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telphoneText);
		passwordField.sendKeys(passwordText);
		passworconfirmdField.sendKeys(confirmPasswordText);
		privacyPolicycheckboxField.click();
		continueButton.click();
		return new AccountSucessPage(driver);
		
		
	}
	public AccountSucessPage regesterWithAllField(String firstNameText,String lastNameText,String emailText,String telphoneText,String passwordText,String confirmPasswordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telphoneText);
		passwordField.sendKeys(passwordText);
		passworconfirmdField.sendKeys(confirmPasswordText);
		yesNewsLatterOption.click();
		privacyPolicycheckboxField.click();
		continueButton.click();
		return new AccountSucessPage(driver);
		
		
	}
	
	public boolean displayStatusOfWarningMassage(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,String expectedLastNameWarning, String expectedEmailWarning, String expectedTelePhoneWarning,String expectedPasswordWarning) {
		

		boolean privacyPolicyWarningStatuse = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);
		
		boolean firstNameWarningStatuse = firstNameWarning.getText().equals(expectedFirstNameWarning);
		
		boolean lastNameWarningStatuse = lastNameWarning.getText().equals(expectedLastNameWarning);
		
		boolean EmailWarningStatuse = emailWarning.getText().equals(expectedEmailWarning);
		
		boolean TelePhoneWarningStatuse = telePhoneWarning.getText().equals(expectedTelePhoneWarning);
		
		boolean passwordWarningStatuse = passwordWarning.getText().equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatuse && firstNameWarningStatuse && lastNameWarningStatuse && EmailWarningStatuse && TelePhoneWarningStatuse && passwordWarningStatuse;
		
		
		
		
		
		
	}
	

}
