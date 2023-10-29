package org.pom;

public class AdactinPageManager {

	private AdactinLoginPom loginPom;
	
	private AdactinSearchPom searchPom;
	
	private AdactinSelectPom selectPom;
	
	private AdactinBookPom bookPom;
	
	public AdactinLoginPom getloginPom() {
		if(loginPom==null) {
			loginPom=new AdactinLoginPom();
		}
		return loginPom;
	}
	public AdactinSearchPom getsearchPom() {
		if(searchPom==null) {
			searchPom= new AdactinSearchPom();
		}
		return searchPom;
	}
	public AdactinSelectPom getselectPom() {
		if(selectPom==null) {
			selectPom=new AdactinSelectPom();
		}
		return selectPom;
	}
	public AdactinBookPom getbookPom() {
		if(bookPom==null) {
			bookPom = new AdactinBookPom();
		}
		return bookPom;
	}
}
