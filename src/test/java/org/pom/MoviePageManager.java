package org.pom;

public class MoviePageManager {

	private ImdbPom imdbPom;
	
	private WikipediaPom wikipediaPom;
	
	
	
	public ImdbPom getimdbPom() {
		if(imdbPom==null) {
			imdbPom=new ImdbPom();
		}
		return imdbPom;
	}
	public WikipediaPom getwikipediaPom() {
		if(wikipediaPom==null) {
			wikipediaPom=new WikipediaPom();
		}
		return wikipediaPom;
	}
}
