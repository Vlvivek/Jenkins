package org.practice;

import org.base.BaseClass;
import org.pom.ImdbPom;
import org.pom.MoviePageManager;
import org.pom.WikipediaPom;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Movie extends BaseClass{
	
	MoviePageManager manager;
	@BeforeClass
	public void initialSetup() {
		LaunchBrowser("chrome");
		implicitWait();
		maximizing();
		manager=new MoviePageManager();
	}
	@AfterClass
	public void tearDown() {
		close();
	}
	@Test
	public void imdb() throws InterruptedException {
		ImdbPom imdbpom = manager.getimdbPom();
		LoadUrl("https://www.imdb.com/");
		String actual = driver.getTitle();
		String expected = "IMDb: Ratings, Reviews, and Where to"
				+ " Watch the Best Movies & TV Shows";
		Assert.assertEquals(actual, expected);
		 passValue(imdbpom.getsearch(), "Sherlock Holmes 2009");
		clickIt(imdbpom.getbutton());
		clickIt(imdbpom.getsherlock());
		Thread.sleep(3000);
		String date = imdbpom.getdate().getText();
		System.out.println("\n");
		System.out.println("Sherlock Holmes 2009"+"\nRelease"
				+ " Date in United States"+"\nTaken From IMDB :"+date);
	}
	@Test
	public void wikipedia() {
		WikipediaPom wikipom = manager.getwikipediaPom();
		LoadUrl("https://www.wikipedia.org/");
		String actual = driver.getTitle();
		String expected ="Wikipedia";
		Assert.assertEquals(actual, expected);
		passValue(wikipom.getsearch(), "Sherlock Holmes 2009");
		clickIt(wikipom.getbutton());
		clickIt(wikipom.gettitle());
		String date = wikipom.getdate().getText();
		System.out.println("\n");
		System.out.println("Sherlock Holmes 2009"+"\nRelease"
				+ " Date in United States"+"\nTaken From Wikipedia :"+date);
		System.out.println("\n");
	}
	
}
