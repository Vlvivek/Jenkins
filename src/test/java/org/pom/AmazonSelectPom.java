package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSelectPom extends BaseClass{
	public AmazonSelectPom(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement SearchBox;
	@FindBy(xpath="//span[text()='Western Digital']")
	private WebElement WesternDigital;
	@FindBy(xpath="//i[contains(@class,'a-icon a-icon-star-medium a-star')]")
	private WebElement Star;
	@FindBy(xpath="//input[@id='low-price']")
	private WebElement minPrice;
	@FindBy(xpath="//input[@id='high-price']")
	private WebElement maxPrice;
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement goButton;
	@FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-')]")
	private WebElement hardDisk;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement cart;
	@FindBy(xpath="(//input[@class='a-button-input'])[18]")
	private WebElement proceed;
	@FindBy(xpath="//span[@class='a-price-whole']")
	private WebElement price;

	
	public WebElement getSearchBox() {
		return SearchBox;
	}
	public WebElement getWesternDigital() {
		return WesternDigital;
	}
	public WebElement getStar() {
		return Star;
	}
	public WebElement getminPrice() {
		return minPrice;
	}
	public WebElement getmaxPrice() {
		return maxPrice;
	}
	public WebElement getgoButton() {
		return goButton;
	}
	public WebElement gethardDisk() {
		return hardDisk;
	}
	public WebElement getcart() {
		return cart;
	}
	public WebElement getproceed() {
		return proceed;
	}
	public WebElement getprice() {
		return price;
	}
}
