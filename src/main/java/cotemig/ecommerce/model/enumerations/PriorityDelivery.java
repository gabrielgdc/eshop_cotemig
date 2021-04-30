package cotemig.ecommerce.model.enumerations;

public class PriorityDelivery extends Enumeration {
    public static final PriorityDelivery High = new PriorityDelivery(1, "High");
    public static final PriorityDelivery Normal = new PriorityDelivery(1, "Normal");

    public PriorityDelivery(int id, String name) {
        super(id, name);
    }
}
