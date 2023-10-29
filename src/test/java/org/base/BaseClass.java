package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebElement element;
	public static WebDriver driver;
	
	public  static void LaunchBrowser(String browser) {
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("invalid!"+" "+"Browser Name");
		}
	}
	public static void LoadUrl(String url) {
		driver.get(url);
	}
	public static void clickIt(WebElement element) {
		element.click();
	}
	public static void maximizing() {
		driver.manage().window().maximize();
	}
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public static void quit() {
		driver.quit();
	}
	public static void passValue(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static String textValue(WebElement element) {
		String text = element.getText();
		return text;
	}
	public static void close() {
		driver.close();
	}
	public static void pageTitle() {
		System.out.println(driver.getTitle());
	}
	public static String parentHandle() {
		String parentWindow = driver.getWindowHandle();
		return parentWindow;
	}
	public static Set<String> allwindowHandle() {
		Set<String> allWindows = driver.getWindowHandles();
		return allWindows;
	}
	public static void  dropDownByValue(WebElement element,String value ) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void dropDownByText(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	public static void scrollByPixel(int X,int Y ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy('"+X+"','"+Y+"')");
	}
	public static void setAttribute(WebElement element,String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
	}
	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	
	
	public static void screenShot(File file) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, file);
	}
	public static File initializeFile(String path) {
		File file = new File(path);
		return file;
	}
	public static Workbook getWorkbook(File file,String fileType) throws IOException {
		FileInputStream input = new FileInputStream(file);
		if(fileType.equalsIgnoreCase("xssf")) {
			Workbook book = new XSSFWorkbook(input);
			return book;
		}else {
			Workbook book = new HSSFWorkbook(input);
			return book;
		}
	}
	public String getSheetVlaue(Workbook book,String name,int rownum,int cellnum) {
		Sheet sheet = book.getSheet(name);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType celltype = cell.getCellType();
		switch (celltype) {
		case STRING:
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");
			String format = date.format(dateCellValue);
				return format;
			}else {
			double numericCellValue = cell.getNumericCellValue();
			long num = (long) numericCellValue;
			String string = Long.toString(num);
			return string;
			}
		case BOOLEAN:
			boolean booleanCellValue = cell.getBooleanCellValue();
			String string = Boolean.toString(booleanCellValue);
			return string;
		default:
			break;
		}
		return name;
	}
	

}
