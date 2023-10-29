package org.practice;

import java.io.File;
import java.io.IOException;

import org.base.BaseClass;
import org.pom.ZomatoCityPom;
import org.pom.ZomatoPageManager;
import org.pom.ZomatoRestaurantPom;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zomato extends BaseClass{
	String name;
	ZomatoPageManager manager;
	@BeforeClass
	public void initialSetup() {
		LaunchBrowser("chrome");
		maximizing();
		LoadUrl("https://www.zomato.com/trichy");
		implicitWait();
		manager = new ZomatoPageManager();
	}
	@BeforeMethod
	public void title() {
		pageTitle();
	}
	@AfterMethod
	public void screenShot() throws IOException {
		File file = initializeFile("C:\\Users\\vlviv\\eclipse pro"
				+ "\\MyProject\\target\\"+name+".png");
		screenShot(file);
	}
	@AfterClass
	public void shut() {
		quit();
	}
	public void selectCity() {
		ZomatoCityPom citypom = manager.getcityPom();
		clickIt(citypom.getcity());
	}
	@Test
	public void restaurant() throws InterruptedException {
		ZomatoRestaurantPom restaurantpom = manager.getrestaurantPom();
		passValue(restaurantpom.getsearch(), "dominos pizza");
		restaurantpom.getsearch().click();
		clickIt(restaurantpom.getdaminos());
		scrollByPixel(400, 400);
		clickIt(restaurantpom.getOrder());
		Thread.sleep(3000);
		clickIt(restaurantpom.getVegpizza());
		clickIt(restaurantpom.getselectone());
	}
	
}
