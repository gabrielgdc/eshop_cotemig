package cotemig.ecommerce.model.entities;

import cotemig.ecommerce.model.enumerations.OrderStatus;
import cotemig.ecommerce.model.enumerations.PriorityDelivery;
import cotemig.ecommerce.model.valueobjects.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Integer id;
    private final Address address;
    private final OrderStatus status;
    private final PriorityDelivery priorityDelivery;
    private final Set<Product> deliveryItems;
    private final double totalPrice;

    public Delivery(Integer id, Address address, OrderStatus status, PriorityDelivery priorityDelivery, Set<Product> deliveryItems, double totalPrice) {
        this.id = id;
        this.address = address;
        this.status = status;
        this.priorityDelivery = priorityDelivery;
        this.deliveryItems = deliveryItems;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PriorityDelivery getPriorityDelivery() {
        return priorityDelivery;
    }

    public Set<Product> getDeliveryItems() {
        return deliveryItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
