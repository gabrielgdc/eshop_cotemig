package cotemig.ecommerce.model.valueobjects;

public class Address extends ValueObject {
    private String street;
    private String zipCode;
    private String district;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String street, String zipCode, String district, String city, String state) {
        this.street = street;
        this.zipCode = zipCode;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
