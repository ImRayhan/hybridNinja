package tutoroalsNinja.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsNinja.qa.Utils.Utillities;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base() {

		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "/src/main/java/com/tutorialsNinja/qa/Config/Config.properties");

		dataProp = new Properties();
		File dtataPropFile = new File(
				System.getProperty("user.dir") + "/src/main/java/com/TutorialNinja/qa/TestData/testData.properties");

		try {

			FileInputStream dataFis = new FileInputStream(dtataPropFile);
			dataProp.load(dataFis);
		} catch (Throwable e) {
			e.printStackTrace();

		}

		try {

			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();

		}

	}

	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utillities.IMPLICIT_WAIT_TIME));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utillities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;

	}

}
