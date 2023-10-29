package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartSelectPom extends BaseClass{
	public FlipkartSelectPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='q']")
	private WebElement Search;
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement cancel;
	@FindBy(xpath="//a[@title='External HDD']")
	private WebElement external;
	@FindBy(xpath="//div[@class='_24_Dny']")
	private WebElement star;
	@FindBy(xpath="//div[@class='_24_Dny _3tCU7L']")
	private WebElement assuredButton;
	@FindBy(xpath="//select[@class='_2YxCDZ']")
	private WebElement minPrice;
	@FindBy(xpath="(//select[@class='_2YxCDZ'])[2]")
	private WebElement maxPrice;
	@FindBy(xpath="//div[text()='WD My Passport 2 TB External Hard Disk Drive (HDD)']")
	private WebElement hardDisk;
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement cart;
	@FindBy(xpath="//div[@class='_30jeq3 _16Jk6d']")
	private WebElement price;
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement order;
	
	public WebElement getSearch() {
		return Search;
	}
	public WebElement getcancel() {
		return cancel;
	}
	public WebElement getexternal() {
		return external;
	}
	public WebElement getstar() {
		return star;
	}
	public WebElement getassuredButton() {
		return assuredButton;
	}
	public WebElement getminPrice() {
		return minPrice;
	}
	public WebElement getmaxPrice() {
		return maxPrice;
	}
	public WebElement gethardDisk() {
		return hardDisk;
	}
	public WebElement getcart() {
		return cart;
	}
	public WebElement getprice() {
		return price;
	}
	public WebElement getorder() {
		return order;
	}
	
	
	
	
	
	
	
	
}
