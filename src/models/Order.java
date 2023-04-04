package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private Client client;
    private Restaurant restaurant;
    private List<Product> products = new ArrayList<Product>();
    private float totalPrice;

    public Order(Client client, Restaurant restaurant, List<Product> products, float totalPrice) {
        this.client = client;
        this.restaurant = restaurant;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.totalPrice, totalPrice) == 0 && Objects.equals(client, order.client) && Objects.equals(restaurant, order.restaurant) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, restaurant, products, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", restaurant=" + restaurant +
                ", products=" + products +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
