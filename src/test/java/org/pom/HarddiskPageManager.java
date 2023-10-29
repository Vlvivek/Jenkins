package org.pom;

public class HarddiskPageManager {
	
	private AmazonSelectPom SelectPom;
	
	private FlipkartSelectPom selectPom;
	
	public AmazonSelectPom getSelectPom() {
		if(SelectPom==null) {
			SelectPom = new AmazonSelectPom();
		}
		return SelectPom;
	}
	public FlipkartSelectPom getselectPom() {
		if(selectPom==null) {
			selectPom=new FlipkartSelectPom();
		}
		return selectPom;
	}
	
}
