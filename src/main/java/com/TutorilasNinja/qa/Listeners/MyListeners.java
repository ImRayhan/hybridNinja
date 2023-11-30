package com.TutorilasNinja.qa.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.qa.Utils.ExtentReporter;
import com.tutorialsNinja.qa.Utils.Utillities;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtenrtReport();

	}

	@Override
	public void onTestStart(ITestResult result) {

		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + "Started exuting");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, result.getName() + "got successfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}

		String destinationScreenshotPath = Utillities.captureScreenShot(driver, result.getName());

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " got skipped");

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathofStringRaeport = System.getProperty("user.dir")+"/test-output/ExtentReports/extentReport.html";
		File extentRerport = new File(pathofStringRaeport);
		try {
			Desktop.getDesktop().browse(extentRerport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
