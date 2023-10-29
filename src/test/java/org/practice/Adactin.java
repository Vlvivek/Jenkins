package org.practice;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pom.AdactinBookPom;
import org.pom.AdactinLoginPom;
import org.pom.AdactinPageManager;
import org.pom.AdactinSearchPom;
import org.pom.AdactinSelectPom;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin extends BaseClass{
	String  name;
	AdactinPageManager manager;
	@Parameters("browser")
	@BeforeClass
	public void startingSetup(@Optional("edge")String browser) {
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
		implicitWait();
		maximizing();
		LoadUrl("https://adactinhotelapp.com/");
		manager = new AdactinPageManager();
	}
	@AfterMethod
	public void takeShot() throws IOException {
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro\\MyProject\\target\\"+name+".png");
		screenShot(file);
	}
	@AfterClass
	public void tearDown() {
		close();
	}
	@Test
	public void verifyLogo() {
		name="Login";
		boolean logo = driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed();
		Assert.assertTrue(logo);
	}
	@Test(priority = 1)
	public void login() throws IOException {
		
		AdactinLoginPom loginpom = manager.getloginPom();
		String actual = driver.getTitle();
		String expected ="Adactin.com - Hotel Reservation System";
		Assert.assertEquals(actual, expected);
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro\\MyProject"
				+ "\\src\\test\\resources\\test.xlsx");
		Workbook book = getWorkbook(file, "xssf");
		String userName = getSheetVlaue(book, "sheet1", 1, 0);
		String pass = getSheetVlaue(book, "sheet1", 1, 1);
		passValue(loginpom.getuserName(), userName);
		passValue(loginpom.getpass(), pass);
		clickIt(loginpom.getloginButton());
	}
	@Test(priority = 2)
	public void search() throws IOException {
		name="search";
		AdactinSearchPom searchpom = manager.getsearchPom();
		String actual =driver.getTitle();
		String expected ="Adactin.com - Search Hotel";
		Assert.assertEquals(actual, expected);
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro\\MyProject"
				+ "\\src\\test\\resources\\test.xlsx");
		Workbook book = getWorkbook(file, "xssf");
		String location = getSheetVlaue(book, "sheet1", 3, 2);
		String hotel = getSheetVlaue(book, "sheet1", 3, 3);
		String roomtype = getSheetVlaue(book, "sheet1", 3, 4);
		String noofroom = getSheetVlaue(book, "sheet1", 3, 5);
		String adults = getSheetVlaue(book, "sheet1", 3, 8);
		String childrens = getSheetVlaue(book, "sheet1", 3, 9);
		
		passValue(searchpom.getlocation(), location);
		passValue(searchpom.gethotels(), hotel);
		passValue(searchpom.getroomType(), roomtype);
		passValue(searchpom.getnoOfRoom(), noofroom);
		setAttribute(searchpom.getcheckinDate(), "14/09/23");
		setAttribute(searchpom.getcheckoutDate(), "16/09/23");
		passValue(searchpom.getadults(), adults);
		passValue(searchpom.getchildrens(), childrens);
		clickIt(searchpom.getsearchButton());
	}
	@Test(priority = 3)
	public void select() {
		name="select";
		AdactinSelectPom selectpom = manager.getselectPom();
		clickIt(selectpom.getradioButton());
		String actual = driver.getTitle();
		String expected = "Adactin.com - Select Hotel";
		Assert.assertEquals(actual, expected);
		String hotelname = getAttribute(selectpom.gethotelName());
		String location = getAttribute(selectpom.getlocation());
		String rooms = getAttribute(selectpom.getrooms());
		String arrdate = getAttribute(selectpom.getarrDate());
		String depdate = getAttribute(selectpom.getdepDate());
		String noofdays = getAttribute(selectpom.getnoOfDays());
		String roomtype = getAttribute(selectpom.getroomType());
		String pricepernight = getAttribute(selectpom.getpricePerNight());
		String totalprice = getAttribute(selectpom.gettotalPrice());
		System.out.println("Hotel Name :"+hotelname+"\nLocation :"+location+"\nNo Of Rooms :"
		+rooms+"\nArrival Date :"+arrdate+"\nDeparture Date:"+depdate+"\nNo Of Days:"+
				noofdays+"\nRoom Type:"+roomtype+"\nPrice Per Night:"+pricepernight+"\nTotel Price:"+totalprice);
		
		clickIt(selectpom.getcontinueButton());	
		
	}
	@Test(priority = 4)
	public void book() throws IOException, InterruptedException {
		name="Book";
		String actual = driver.getTitle();
		String expected = "Adactin.com - Book A Hotel";
		Assert.assertEquals(actual, expected);
		AdactinBookPom bookpom = manager.getbookPom();
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro\\MyProject\\"
				+ "src\\test\\resources\\test.xlsx");
		Workbook book = getWorkbook(file, "xssf");
		String firstname = getSheetVlaue(book, "sheet1", 6, 2);
		String lastname = getSheetVlaue(book, "sheet1", 6, 3);
		String address = getSheetVlaue(book, "sheet1", 6, 4);
		String cardno = getSheetVlaue(book, "sheet1", 6, 5);
		String cardtype = getSheetVlaue(book, "sheet1", 6, 6);
		String expriymonth = getSheetVlaue(book, "sheet1", 6, 7);
		String expriyyear = getSheetVlaue(book, "sheet1", 6, 8);
		String cvv = getSheetVlaue(book, "sheet1", 6, 9);
		
		passValue(bookpom.getfirstName(), firstname);
		passValue(bookpom.getlastName(), lastname);
		passValue(bookpom.getaddress(), address);
		passValue(bookpom.getcardNo(), cardno);
		passValue(bookpom.getcardType(), cardtype);
		passValue(bookpom.getexpriyMonth(), expriymonth);
		passValue(bookpom.getexpriyYear(), expriyyear);
		passValue(bookpom.getcvv(), cvv);
		clickIt(bookpom.getbook());
		Thread.sleep(3000);
		String orderno = getAttribute(bookpom.getorderNo());
		System.out.println("Hotel Booking No:"+orderno);
	}
}
