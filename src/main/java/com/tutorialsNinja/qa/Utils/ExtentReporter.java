package com.tutorialsNinja.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtenrtReport() {

		ExtentReports extentReports = new ExtentReports();

		File extentReportFile = new File(
				System.getProperty("user.dir") + "/test-output/ExtentReports/extentReport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Result");
		sparkReporter.config().setDocumentTitle("Tn Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");

		extentReports.attachReporter(sparkReporter);

		Properties configProp = new Properties();
		File configPropFile = new File(
				System.getProperty("user.dir") + "/src/main/java/com/tutorialsNinja/qa/Config/Config.properties");
		FileInputStream fisConfigProp;
		try {
			fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (FileNotFoundException e) {

		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentReports.setSystemInfo("Applocation URL", configProp.getProperty("url"));
		extentReports.setSystemInfo("browser name", configProp.getProperty("browserName"));
		extentReports.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReports.setSystemInfo("Password", configProp.getProperty("validPass"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return extentReports;
	}

}
