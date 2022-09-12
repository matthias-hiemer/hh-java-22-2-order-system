import model.Product;
import repo.ProductRepo;
import service.ShopService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("A-100", "iPhone"),
                new Product("A-200", "Samsung Galaxy"),
                new Product("A-300", "Kniffel-Set")
        );

        ProductRepo productRepo = new ProductRepo(products);
        ShopService shopService = new ShopService(productRepo);

        System.out.println(shopService.listProducts());
        System.out.println(shopService.getProduct("A-300"));

    }
}
