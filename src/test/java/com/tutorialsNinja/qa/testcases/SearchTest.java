package com.tutorialsNinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorials.qa.Pages.HomePage;
import com.Tutorials.qa.Pages.SearchPage;

import tutoroalsNinja.qa.Base.Base;

public class SearchTest extends Base {

	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;

	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		searchPage = homePage.searchForAProduct(dataProp.getProperty("RvalidProduct"));

		Assert.assertTrue(searchPage.displayStatusOfHpValidProduct(), "hp product is not displayed");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {

		searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidroduct"));

		Assert.assertEquals(searchPage.noProductMassageText(), dataProp.getProperty("noProductTextInSearchResult"),
				"no product massage in search");

	}

	@Test(priority = 3,dependsOnMethods = {"verifySearchWithValidProduct","verifySearchWithInvalidProduct"})
	public void verifySearchWithWithoutAnyProduct() {

		searchPage = homePage.clickOnSearchButton();

		Assert.assertEquals(searchPage.noProductMassageText(), dataProp.getProperty("noProductTextInSearchResult"),
				"no product massage in search");

	}

}
