package models;

import java.util.List;
import java.util.Objects;

public class Delivery extends Order{
    private Driver driver;
    private String address;
    private String dateOfDelivery;

    public Delivery(Client client, Restaurant restaurant, List<Product> products, float totalPrice, Driver driver, String address, String dateOfDelivery) {
        super(client, restaurant, products, totalPrice);
        this.driver = driver;
        this.address = address;
        this.dateOfDelivery = dateOfDelivery;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(driver, delivery.driver) && Objects.equals(address, delivery.address) && Objects.equals(dateOfDelivery, delivery.dateOfDelivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), driver, address, dateOfDelivery);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "driver=" + driver +
                ", address='" + address + '\'' +
                ", dateOfDelivery='" + dateOfDelivery + '\'' +
                '}';
    }
}
