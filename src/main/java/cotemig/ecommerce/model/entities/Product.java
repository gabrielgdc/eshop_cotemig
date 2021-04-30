package cotemig.ecommerce.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private Integer productUnits;
    private double unitWeight;

    public Product(String productName, Integer productUnits, double unitWeight) {
        this.productName = productName;
        this.productUnits = productUnits;
        this.unitWeight = unitWeight;
    }

    protected Product() {
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
