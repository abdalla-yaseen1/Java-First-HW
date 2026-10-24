package food_Delivery;

public class CardPay implements PaymentMethod {

	public double pay(double amount) {
		return amount+(amount*2/100);
	}
}
