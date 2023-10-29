package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPom extends BaseClass{

	public WikipediaPom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='searchInput']")
	private WebElement search;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button;
	@FindBy(xpath="//a[@title='Sherlock Holmes (2009 film)']")
	private WebElement title;
	@FindBy(xpath="//li[text()=' (United States)']")
	private WebElement date;
	
	public WebElement getsearch() {
		return search;
	}
	public WebElement getbutton() {
		return button;
	}
	public WebElement gettitle() {
		return title;
	}
	public WebElement getdate() {
		return date;
	}
}
