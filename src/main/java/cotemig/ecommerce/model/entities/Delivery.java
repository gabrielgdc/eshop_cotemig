package cotemig.ecommerce.model.entities;

import cotemig.ecommerce.model.enumerations.OrderStatus;
import cotemig.ecommerce.model.enumerations.PriorityDelivery;
import cotemig.ecommerce.model.exceptions.DomainException;
import cotemig.ecommerce.model.valueobjects.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private Set<Product> deliveryItems = new HashSet<>();

    @Embedded
    private PriorityDelivery priorityDelivery;

    private String phone;

    private String description;

    private double totalPrice;

    @Embedded
    private OrderStatus status;

    private Integer statusId;

    private double distanceKm;

    public Delivery() {}

    public Delivery(String phone, String description, int distanceKm, Address address) {
        this.phone = phone;
        this.address = address;
        this.description = description;
        this.distanceKm = distanceKm;
        this.statusId = OrderStatus.stockConfirmation.id;
        this.status = OrderStatus.stockConfirmation;
    }

    public Integer getId() {
        return id;
    }

    public void addDeliveryProduct(Product product) throws Exception {
        var itemExist = deliveryItems.stream().anyMatch((a) -> a.getId().equals(product.getId()));

        if (itemExist) {
            throw new DomainException("Produto já foi adicionado");
        }

        deliveryItems.add(product);
        product.setDelivery(this);

        calculateGoods();
    }

    public void setDeliveryPriority(boolean isDamageProne) {
        priorityDelivery = isDamageProne ? PriorityDelivery.high : PriorityDelivery.normal;
    }

    public void calculateGoods() {
        var totalWeight = deliveryItems.stream().map(Product::getUnitWeight).reduce(0.0, Double::sum);

        if (deliveryItems.size() >= 20) {
            totalPrice = totalWeight / 2;
        } else {
            totalPrice = 1.50 * distanceKm;
        }
    }

    public void updateDelivery(double newDistanceKm, String newDescription, String newPhone, PriorityDelivery priority, Address address) throws DomainException {
        if (statusId == OrderStatus.confirmed.id) throw new DomainException("Impossível alterar uma ordem confirmada");

        distanceKm = newDistanceKm;
        description = newDescription;
        phone = newPhone;
        priorityDelivery = priority;
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
