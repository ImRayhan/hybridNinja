package com.Tutorials.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHpProduct;
	
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noProductMassage;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean displayStatusOfHpValidProduct() {
	boolean displayStatusOfHpValidProduct = 	validHpProduct.isDisplayed();
	return displayStatusOfHpValidProduct;
		
	}
	public String noProductMassageText() {
		String noProductMassageText = 	noProductMassage.getText();
		return noProductMassageText;
		
		
	}

}
