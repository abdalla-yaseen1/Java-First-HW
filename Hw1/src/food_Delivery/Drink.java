package food_Delivery;

public class Drink extends MenuItem {

	private boolean isLarge=false;

	public Drink(String name, double basePrice, boolean isLarge) {
		super(name, basePrice);
		this.isLarge = isLarge;
	}
	@Override
	public double getFinalPrice() {

		if (this.isLarge) {
			
			return getBasePrice()+1;
		}
		else
			return getBasePrice();

	}
}

