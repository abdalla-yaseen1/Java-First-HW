
package food_Delivery;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 1000;

    private int orderNum;
    private String custmerName;
    private OrderStatus status;
    private DeliveryOption delivery;
    private List<OrderLine> lines;

    public Order(String custmerName, DeliveryOption delivery) {
        this.orderNum = ++counter;
        this.custmerName = custmerName;
        this.delivery = delivery;
        this.status = OrderStatus.NEW;
        this.lines = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quntity) {
        if (status != OrderStatus.NEW) {
            System.out.println("Cannot add items unless the order is NEW.");
            return;
        }

        if (quntity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        lines.add(new OrderLine(item, quntity));
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public double getSubTotal() {
        double subTotal = 0;

        for (OrderLine line : lines) {
            subTotal += line.getSubTotal();
        }

        return subTotal;
    }

    public double getTotal() {
        return getSubTotal() + delivery.getFee();
    }

    public void pay(PaymentMethod method) {
        if (status != OrderStatus.NEW) {
            System.out.println("Only NEW orders can be paid.");
            return;
        }

        double amount = method.pay(getTotal());

        System.out.println("Payment amount: " + amount);

        status = OrderStatus.PAID;
    }

    public void deliver() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.DELIVERED;
            System.out.println("Order delivered successfully.");
        } else {
            System.out.println("Only PAID orders can be delivered.");
        }
    }

    public void cancel() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.CANCELLED;
            System.out.println("Order cancelled successfully.");
        } else {
            System.out.println("Only NEW orders can be cancelled.");
        }
    }
}
