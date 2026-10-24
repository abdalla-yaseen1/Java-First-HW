
package food_Delivery;

public class Main {

    public static void main(String[] args) {

        Meal burger = new Meal("Burger", 8, 1);
        Drink juice = new Drink("Juice", 3, true);

        DeliveryOption delivery = new ExpressDelivery();

        Order order = new Order("Ahmad", delivery);

        order.addItem(burger, 2);
        order.addItem(juice);

        System.out.println("Subtotal: " + order.getSubTotal());
        System.out.println("Total: " + order.getTotal());

        PaymentMethod payment = new CardPay();
        order.pay(payment);

        order.deliver();
    }
}
