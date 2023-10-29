package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSearchPom extends BaseClass{
	public AdactinSearchPom() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='location']")
	private WebElement location;
	@FindBy(xpath="//select[@id='hotels']")
	private WebElement hotels;
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement noOfRoom;
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement checkinDate;
	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement checkoutDate;
	@FindBy(xpath="//select[@id='adult_room']")
	private WebElement adults;
	@FindBy(xpath="//select[@id='child_room']")
	private WebElement childrens;
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement searchBuuton;

	
	public WebElement getlocation() {
		return location;
	}
	public WebElement gethotels() {
		return hotels;
	}
	public WebElement getroomType() {
		return roomType;
	}
	public WebElement getnoOfRoom() {
		return noOfRoom;
	}
	public WebElement getcheckinDate() {
		return checkinDate;
	}
	public WebElement getcheckoutDate() {
		return checkoutDate;
	}
	public WebElement getadults() {
		return adults;
	}
	public WebElement getchildrens() {
		return childrens;
	}
	public WebElement getsearchButton() {
		return searchBuuton;
	}
	
	
	
	
	
	
	
	
	
	
	
}
