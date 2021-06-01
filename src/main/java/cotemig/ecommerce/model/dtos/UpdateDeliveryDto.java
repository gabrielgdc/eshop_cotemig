package cotemig.ecommerce.model.dtos;

import cotemig.ecommerce.model.enumerations.PriorityDelivery;
import cotemig.ecommerce.model.valueobjects.Address;

public class UpdateDeliveryDto {
    private Address address;
    private String phone;
    private String description;
    private PriorityDelivery priorityDelivery;
    private double distanceKm;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityDelivery getPriorityDelivery() {
        return priorityDelivery;
    }

    public void setPriorityDelivery(PriorityDelivery priorityDelivery) {
        this.priorityDelivery = priorityDelivery;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }
}
