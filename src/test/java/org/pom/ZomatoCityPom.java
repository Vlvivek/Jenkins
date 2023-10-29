package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZomatoCityPom extends BaseClass{
	public ZomatoCityPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h5[text()='Trichy Restaurants']")
	private WebElement city;
	
	
	public WebElement getcity() {
		return city;
	}

}
