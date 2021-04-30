package cotemig.ecommerce.model.enumerations;

public class OrderStatus extends Enumeration {
    public static OrderStatus StockConfirmation = new OrderStatus(1, "StockConfirmation");
    public static OrderStatus Confirmed = new OrderStatus(2, "Confirmed");
    public static OrderStatus Cancelled = new OrderStatus(3, "Cancelled");

    public OrderStatus(int id, String name) {
        super(id, name);
    }
}
