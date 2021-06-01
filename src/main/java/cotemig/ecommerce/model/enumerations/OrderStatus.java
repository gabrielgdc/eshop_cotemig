package cotemig.ecommerce.model.enumerations;

public class OrderStatus extends Enumeration {
    public static OrderStatus stockConfirmation = new OrderStatus(1, "StockConfirmation");
    public static OrderStatus confirmed = new OrderStatus(2, "Confirmed");
    public static OrderStatus cancelled = new OrderStatus(3, "Cancelled");

    public OrderStatus(int id, String name) {
        super(id, name);
    }
}
