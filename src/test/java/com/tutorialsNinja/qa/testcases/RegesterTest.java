package com.tutorialsNinja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Tutorials.qa.Pages.AccountSucessPage;
import com.Tutorials.qa.Pages.HomePage;
import com.Tutorials.qa.Pages.RegesterPage;
import com.tutorialsNinja.qa.Utils.Utillities;

import tutoroalsNinja.qa.Base.Base;

public class RegesterTest extends Base {

	public WebDriver driver;
	RegesterPage regesterPage;
	AccountSucessPage accountSucessPage;

	public RegesterTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);
		regesterPage = homePage.navigateToRegisterPae();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test(priority = 1)
	public void verifyRegesteringAnAccountWithMandatoryFields() {

		accountSucessPage = regesterPage.regesterWithmandatoryField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utillities.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPass"), prop.getProperty("validPass"));

		Assert.assertEquals(accountSucessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccesfullyCreatedHeading"), "Account successs page is no displayed");

	}

	@Test(priority = 2)
	public void verifyRegesteringAccountByProvidingAllFields() {
		accountSucessPage = regesterPage.regesterWithAllField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utillities.generateEmailTimeStamp(),
				dataProp.getProperty("telephoneNumber"), prop.getProperty("validPass"), prop.getProperty("validPass"));

		Assert.assertEquals(accountSucessPage.retrieveAccountSuccessPageHeading(),
				dataProp.getProperty("accountSuccesfullyCreatedHeading"), "Account successs page is no displayed");

	}

	@Test(priority = 3)
	public void verifyrRegesteringAccountWithExistingEmailAddress() {
		regesterPage.regesterWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPass"),
				prop.getProperty("validPass"));

		Assert.assertTrue(
				regesterPage.retrieveDuplicateEmailAdressWarning()
						.contains(dataProp.getProperty("duplicateEMAILwARNING")),
				"warning massage regrading duplicate massage is not displayed");

	}

	@Test(priority = 4)
	public void verifyrRegesteringAccountWithWithoutFillingDetails() {

		regesterPage.clickContinueButton();

		Assert.assertTrue(regesterPage.displayStatusOfWarningMassage(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")), "Warning massages are not displayed");


	}

}
