package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSelectPom extends BaseClass{
	public AdactinSelectPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='radiobutton_0']")
	private WebElement radioButton;
	@FindBy(xpath="//input[@id='hotel_name_0']")
	private WebElement hotelName;
	@FindBy(xpath="//input[@id='location_0']")
	private WebElement location;
	@FindBy(xpath="//input[@id='rooms_0']")
	private WebElement rooms;
	@FindBy(xpath="//input[@id='arr_date_0']")
	private WebElement arrDate;
	@FindBy(xpath="//input[@id='dep_date_0']")
	private WebElement depDate;
	@FindBy(xpath="//input[@id='no_days_0']")
	private WebElement noOfDays;
	@FindBy(xpath="//input[@id='room_type_0']")
	private WebElement roomType;
	@FindBy(xpath="//input[@id='price_night_0']")
	private WebElement pricePerNight;
	@FindBy(xpath="//input[@id='total_price_0']")
	private WebElement totalPrice;
	@FindBy(xpath="//input[@id='continue']")
	private WebElement continueButton;

	
	public WebElement getradioButton() {
		return radioButton;
	}
	public WebElement gethotelName() {
		return hotelName;
	}
	public WebElement getlocation() {
		return location;
	}
	public WebElement getrooms() {
		return rooms;
	}
	public WebElement getarrDate() {
		return arrDate;
	}
	public WebElement getdepDate() {
		return depDate;
	}
	public WebElement getnoOfDays() {
		return noOfDays;
	}
	public WebElement getroomType() {
		return roomType;
	}
	public WebElement getpricePerNight() {
		return pricePerNight;
	}
	public WebElement gettotalPrice() {
		return totalPrice;
	}
	public WebElement getcontinueButton() {
		return continueButton;
	}
	
	
	
	
}
