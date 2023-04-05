package service;

import exeptions.InvalidDataExc;
import models.Product;
import repositories.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductService {
    private ProductRepo productRepo = new ProductRepo();

    public void registerNewProduct(String product_name, float price, List<String> ingredients) {
        Product product = new Product(product_name, price, ingredients);
        productRepo.add(product);
    }

    public Product[] getAllProducts() {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < productRepo.getSize(); i++) {
            if (productRepo.get(i) != null) {
                result.add(productRepo.get(i));
            }
        }
        return result.toArray(new Product[0]);
    }

    public void removeAProduct(String product_name) throws InvalidDataExc {
        boolean ok = true;
        int i;

        for (i = 0; i < productRepo.getNumberOf() && ok; i++) {
            if (Objects.equals(productRepo.get(i).getProduct_name(), product_name))
                ok = false;
        }
        if (ok)
            throw new InvalidDataExc("Invalid Product");
        else
            productRepo.delete(productRepo.get(i - 1));
    }
}
