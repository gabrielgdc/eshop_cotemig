package cotemig.ecommerce.model.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productName;

    private Integer productUnits;

    private double unitWeight;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Product(String productName, Integer productUnits, double unitWeight) {
        this.productName = productName;
        this.productUnits = productUnits;
        this.unitWeight = unitWeight;
    }

    protected Product() {
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductUnits() {
        return productUnits;
    }

    public double getUnitWeight() {
        return unitWeight;
    }
}
