package com.tutorialsNinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Tutorials.qa.Pages.AccountPage;
import com.Tutorials.qa.Pages.HomePage;
import com.Tutorials.qa.Pages.LoginPage;
import com.tutorialsNinja.qa.Utils.Utillities;

import tutoroalsNinja.qa.Base.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.navigateToLoginPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test(priority = 1, dataProvider = "validCreditialSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		accountPage = loginPage.logIn(email, password);

		Assert.assertTrue(accountPage.getDisplayStatusEditYourAccountInforamtionOption(),
				"Edit your Account information is not displayed++");

	}

	@DataProvider(name = "validCreditialSupplier")
	public Object[][] supplyTestData() {
		Object[][] data = Utillities.gettestDataFromExcel("Login");
		return data;

	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginPage.logIn(Utillities.generateEmailTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMassageText().contains(dataProp.getProperty("emailPasswordNomatchWarning")),
				"Expected warning massage is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
		
		 loginPage.logIn(Utillities.generateEmailTimeStamp(), prop.getProperty("validPass"));
		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMassageText().contains(dataProp.getProperty("emailPasswordNomatchWarning")),
				"Expected warning massage is not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithvalidEmailAndInValidPassword() {
		accountPage = loginPage.logIn(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));

		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMassageText().contains(dataProp.getProperty("emailPasswordNomatchWarning")),
				"Expected warning massage is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {

		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMassageText().contains(dataProp.getProperty("emailPasswordNomatchWarning")),
				"Expected warning massage is not displayed");

	}

}
