package service;

import model.Product;
import org.junit.jupiter.api.Test;
import repo.ProductRepo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void listProducts_whenCalled_returnAllProducts(){

        // GIVEN
        ProductRepo productRepo = generateProductRepo();
        ShopService shopService = new ShopService(productRepo);

        // WHEN
        List<Product> actual = shopService.listProducts();

        // THEN
        List<Product> expected = List.of(
                new Product("A1", "Apfel"),
                new Product("A2", "Banane"),
                new Product("A3", "Zitrone")
        );
        assertEquals(expected, actual);
    }

    @Test
    void get_whenGivenExistingId_returnsFoundProduct(){

        // GIVEN
        ProductRepo productRepo = generateProductRepo();
        ShopService shopService = new ShopService(productRepo);

        // WHEN
        Product actual = shopService.getProduct("A2");

        // THEN
        Product expected = new Product("A2", "Banane");
        assertEquals(expected, actual);

    }


    private static ProductRepo generateProductRepo() {
        Product product1 = new Product("A1", "Apfel");
        Product product2 = new Product("A2", "Banane");
        Product product3 = new Product("A3", "Zitrone");

        List<Product> productList = List.of(product1, product2, product3);

        ProductRepo productRepo = new ProductRepo(productList);

        return productRepo;
    }

}