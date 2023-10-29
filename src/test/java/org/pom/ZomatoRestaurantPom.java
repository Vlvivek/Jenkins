package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZomatoRestaurantPom extends BaseClass{
	public ZomatoRestaurantPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[contains(@placeholder,'Search for restaurant, cuisine ')]")
	private WebElement search;
	@FindBy(xpath="//p[text()='Thillai Nagar, Trichy']")
	private WebElement daminos;
	@FindBy(xpath="//a[text()='Order Online']")
	private WebElement order;
	@FindBy(xpath="//p[text()='Veg Pizza (18)']")
	private WebElement vegpizza;
	@FindBy(xpath="//h4[text()='Indi Tandoori Paneer Pizza']")
	private WebElement selectone;
	
	
	public WebElement getsearch() {
		return search;
	}
	public WebElement getdaminos() {
		return daminos;
	}
	public WebElement getOrder() {
		return order;
	}
	public WebElement getVegpizza() {
		return vegpizza;
	}
	public WebElement getselectone() {
		return selectone;
	}
}
