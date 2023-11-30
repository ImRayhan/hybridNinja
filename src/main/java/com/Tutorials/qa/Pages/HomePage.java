package com.Tutorials.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenue;

	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement regesterOption;
	
	@FindBy(xpath = "//input[@class='form-control input-lg']")
	private WebElement searchFieldBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Action
	
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public LoginPage navigateToLoginPage() {
		myAccountDropMenue.click();
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegesterPage selectRegesterOption() {
		regesterOption.click();
		return new RegesterPage(driver);
		
	}
	
	public RegesterPage navigateToRegisterPae() {
		myAccountDropMenue.click();
		regesterOption.click();
		return new RegesterPage(driver);
		
		
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click(); 
		return new SearchPage(driver);
		
	}
	
	public void enterProductIntoSearchBoxField(String productText) {
		searchFieldBox.sendKeys(productText);
		
	}
	
	public SearchPage searchForAProduct(String producttext) {
		searchFieldBox.sendKeys(producttext);
		searchButton.click();
		return new SearchPage(driver);	
	}
	

}
