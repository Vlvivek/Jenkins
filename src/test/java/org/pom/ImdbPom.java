package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbPom extends BaseClass{
	
	public ImdbPom() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='q']")
	private WebElement search;
	@FindBy(xpath="//button[@id='suggestion-search-button']")
	private WebElement button;
	@FindBy(xpath="//div[@class='ipc-metadata-list-summary-item__c']")
	private WebElement sherlock;
	@FindBy(xpath="//a[text()='December 25, 2009 (United States)']")
	private WebElement date;
	
	
	public WebElement getsearch() {
		return search;
	}
	public WebElement getbutton() {
		return button;
	}
	public WebElement getsherlock() {
		return sherlock;
	}
	public WebElement getdate() {
		return date;
	}
}
