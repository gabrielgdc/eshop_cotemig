package cotemig.ecommerce.model.viewmodels;

import cotemig.ecommerce.model.entities.Product;

import java.util.List;

public class CreateDeliveryVm {
    private String Cnpj;
    private String Phone;
    private String Description;
    private String ZipCode;
    private String District;
    private String City;
    private String Street;
    private String State;
    private boolean IsDamageProneDelivery;
    private int Km;
    private List<Product> Products;

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String cnpj) {
        Cnpj = cnpj;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public boolean isDamageProneDelivery() {
        return IsDamageProneDelivery;
    }

    public void setDamageProneDelivery(boolean damageProneDelivery) {
        IsDamageProneDelivery = damageProneDelivery;
    }

    public int getKm() {
        return Km;
    }

    public void setKm(int km) {
        Km = km;
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
