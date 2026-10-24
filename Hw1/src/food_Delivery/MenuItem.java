package food_Delivery;

public abstract class MenuItem {
	private String name;
	private double basePrice;

	public String getName() {

		return this.name;
	}

	public double getBasePrice() {

		return this.basePrice;
	}
	
	 public MenuItem(String name, double basePrice) {
	        this.name = name;
	        this.basePrice = basePrice;
	    }
	 
	 

	public abstract double getFinalPrice();

}
