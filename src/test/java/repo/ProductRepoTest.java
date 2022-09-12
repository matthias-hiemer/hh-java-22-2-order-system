package repo;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void list_whenCalled_returnAllProducts() {
        // GIVEN
        Product product1 = new Product("A1", "Apfel");
        Product product2 = new Product("A2", "Banane");
        Product product3 = new Product("A3", "Zitrone");

        List<Product> productList = List.of(product1, product2, product3);

        ProductRepo productRepo = new ProductRepo(productList);

        // WHEN
        List<Product> actual = productRepo.list();

        // THEN
        assertEquals(productList, actual);
    }

    @Test
    void get_whenGivenExistingId_returnProductById(){

        // GIVEN
        // TODO refactor (boiler plate code)
        Product product1 = new Product("A1", "Apfel");
        Product product2 = new Product("A2", "Banane");
        Product product3 = new Product("A3", "Zitrone");

        List<Product> productList = List.of(product1, product2, product3);

        ProductRepo productRepo = new ProductRepo(productList);

        // WHEN
        Product actual = productRepo.get("A2");

        // THEN
        Product expected = new Product("A2", "Banane");
        assertEquals(expected, actual);
    }
}