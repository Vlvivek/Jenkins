package org.practice;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.base.BaseClass;
import org.openqa.selenium.Keys;
import org.pom.AmazonSelectPom;
import org.pom.FlipkartSelectPom;
import org.pom.HarddiskPageManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Harddisk extends BaseClass{
	String name ;
	HarddiskPageManager manager;
	public  String amazonprice;
	public  String filpkartprice;
	@BeforeClass
	public void initialSetup() {
		LaunchBrowser("edge");
		implicitWait();
		maximizing();
		manager = new HarddiskPageManager();
	}
	@BeforeMethod
	public void title() {
		pageTitle();
	}
	@AfterMethod
	public void takeScreenShot() throws IOException {
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro\\MyProject"
				+ "\\target\\"+name+".png");
		screenShot(file);
	}
	@AfterClass
	public void shut() {
		quit();
	}
	
	
	@Test
	public void amazon() throws InterruptedException {
		name="amazon";
		LoadUrl("https://www.amazon.in/");
		AmazonSelectPom selectpom = manager.getSelectPom();
		passValue(selectpom.getSearchBox(), "external hard disk 2tb");
		selectpom.getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		clickIt(selectpom.getWesternDigital());
		clickIt(selectpom.getStar());
		passValue(selectpom.getminPrice(), "4000");
		passValue(selectpom.getmaxPrice(), "12000");
		clickIt(selectpom.getgoButton());
		Thread.sleep(3000);
		clickIt(selectpom.gethardDisk());
		amazonprice = selectpom.getprice().getText();
		char[] charArray = amazonprice.toCharArray();
		String s ="";
		for (char c : charArray) {
			if(Character.isDigit(c)) {
				s=s+c;
			}
		}
		
		int parseInt = Integer.parseInt(s);
		
		System.out.println("Western Digital WD 2TB,External HDD Price in AMAZON "+s);
		clickIt(selectpom.getcart());
		//clickIt(selectpom.getproceed());
		
	}
	@Test
	public void filpkart() throws InterruptedException {
		name="filpkart";
		LoadUrl("https://www.flipkart.com/");
		FlipkartSelectPom selectpom = manager.getselectPom();
		passValue(selectpom.getSearch(), "external hard disk 2tb");
		selectpom.getSearch().sendKeys(Keys.ENTER);
		try {
			String parentHandle = parentHandle();
			Set<String> allwindowHandle = allwindowHandle();
			for(String window : allwindowHandle) {
				if(!allwindowHandle.equals(parentHandle)) {
					driver.switchTo().window(window);
				}
				clickIt(selectpom.getcancel());
			}
			
		} catch (Exception e) {
			
		}
		Thread.sleep(4000);
		clickIt(selectpom.getexternal());
		clickIt(selectpom.getstar());
		Thread.sleep(3000);
		clickIt(selectpom.getassuredButton());
		Thread.sleep(3000);
		dropDownByValue(selectpom.getmaxPrice(), "10000");
		dropDownByValue(selectpom.getminPrice(), "5000");
		Thread.sleep(3000);
		clickIt(selectpom.gethardDisk());
		String parentHandle = parentHandle();
		Set<String> allwindowHandle = allwindowHandle();
		for(String window : allwindowHandle) {
			if(!allwindowHandle.equals(parentHandle)) {
				driver.switchTo().window(window);
			}
			
		}
		filpkartprice = textValue(selectpom.getprice());
		System.out.println("Western Digital WD 2TB,External HDD Price in Filpkart "+filpkartprice);
		clickIt(selectpom.getcart());
		clickIt(selectpom.getorder());	
		
	}
	
		
}
