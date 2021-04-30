package cotemig.ecommerce.model.entities;

import cotemig.ecommerce.model.enumerations.OrderStatus;
import cotemig.ecommerce.model.enumerations.PriorityDelivery;
import cotemig.ecommerce.model.exceptions.DomainException;
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
    private Integer id;
    private Address address;
    private Set<Product> deliveryItems;
    private PriorityDelivery priorityDelivery;
    private String phone;
    private String description;
    private double totalPrice;
    private OrderStatus status;
    private Integer statusId;
    private double distanceKm;

    public Delivery(String phone, String description, int distanceKm, Address address) {
        this.phone = phone;
        this.address = address;
        this.description = description;
        this.distanceKm = distanceKm;
        this.statusId = OrderStatus.StockConfirmation.id;
    }

    public Integer getId() {
        return id;
    }

    public void AddDeliveryProduct(Product product) throws Exception {
        var itemExist = deliveryItems.stream().anyMatch((a) -> a.getId().equals(product.getId()));

        if (itemExist) {
            throw new DomainException("Produto já foi adicionado");
        }

        deliveryItems.add(product);

        CalculateGoods();
    }

    public void SetDeliveryPriority(boolean isDamageProne) {
        priorityDelivery = isDamageProne ? PriorityDelivery.High : PriorityDelivery.Normal;
    }

    public void CalculateGoods() {
        var totalWeight = deliveryItems.stream().map(Product::getUnitWeight).reduce(0.0, Double::sum);

        if (deliveryItems.size() >= 20) {
            totalPrice = totalWeight / 2;
        } else {
            totalPrice = 1.50 * distanceKm;
        }
    }

    public Address getAddress() {
        return address;
    }

    public Set<Product> getDeliveryItems() {
        return deliveryItems;
    }

    public PriorityDelivery getPriorityDelivery() {
        return priorityDelivery;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getDistanceKm() {
        return distanceKm;
    }
}
