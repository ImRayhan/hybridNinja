package com.tutorialsNinja.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utillities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 5;

	public static String generateEmailTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "imrayhanc" + timeStamp + "@gmail.com";

	}

	public static Object[][] gettestDataFromExcel(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")
				+ "/src/main/java/com/TutorialNinja/qa/TestData/TutorialNinjaTestData.xlsx");
		XSSFWorkbook workbook = null;
		try {
			FileInputStream fisExcwl = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcwl);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int colum = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][colum];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < colum; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:

					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;

				}

			}

		}
		return data;

	}

	public static String captureScreenShot(WebDriver driver, String testName) {
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destinationScreenshotPath = System.getProperty("user.dir") + "/Screenshots/" + testName + ".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {

			e.printStackTrace();
		}return destinationScreenshotPath;

	}

}
