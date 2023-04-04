package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private String product_name;
    private float price;
    private List<String> ingredients = new ArrayList<String>();


    public String getProduct_name() {
        return this.product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Product(String product_name, float price, List<String> ingredients) {
        this.product_name = product_name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public  Product() {
        this.product_name = null;
        this.price = 0;
        this.ingredients.add("Not available");
    }

    public boolean includesIngredient(String word) {
        return ingredients.contains(word);
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && Objects.equals(product_name, product.product_name) && Objects.equals(ingredients, product.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_name, price, ingredients);
    }
}
