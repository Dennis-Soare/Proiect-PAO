package models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Menu {
    Restaurant restaurant;
    Set<Product> products = new HashSet<Product>();

    public Menu(Restaurant restaurant, Set<Product> products) {
        this.restaurant = restaurant;
        this.products = products;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(restaurant, menu.restaurant) && Objects.equals(products, menu.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant, products);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurant=" + restaurant +
                ", products=" + products +
                '}';
    }
}
