package org.pom;

public class ZomatoPageManager {
	
	private ZomatoCityPom cityPom;
	
	private ZomatoRestaurantPom restaurantPom;
	
	
	
	
	public ZomatoCityPom getcityPom() {
		if(cityPom==null) {
			cityPom = new ZomatoCityPom();
		}
		return cityPom;
	}
	public ZomatoRestaurantPom getrestaurantPom() {
		if(restaurantPom==null) {
			restaurantPom=new ZomatoRestaurantPom();
		}
		return restaurantPom;
	}
	
	

}
