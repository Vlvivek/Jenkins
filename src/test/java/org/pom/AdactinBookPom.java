package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookPom extends BaseClass{
	public AdactinBookPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastName;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement cardNo;
	@FindBy(xpath="//select[@id='cc_type']")
	private WebElement cardType;
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement expriyMonth;
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement expriyYear;
	@FindBy(xpath="//input[@id='cc_cvv']")
	private WebElement cvv;
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement book;
	@FindBy(xpath="//input[@name='order_no']")
	private WebElement orderNo;
	
	
	public WebElement getfirstName() {
		return firstName;
	}
	public WebElement getlastName() {
		return lastName;
	}
	public WebElement getaddress() {
		return address;
	}
	public WebElement getcardNo() {
		return cardNo;
	}
	public WebElement getcardType() {
		return cardType;
	}
	public WebElement getexpriyMonth() {
		return expriyMonth;
	}
	public WebElement getexpriyYear() {
		return expriyYear;
	}
	public WebElement getcvv() {
		return cvv;
	}
	public WebElement getbook() {
		return book;
	}
	public WebElement getorderNo() {
		return orderNo;
	}

}
