package service;

import model.Product;
import repo.ProductRepo;

import java.util.List;

public class ShopService {

    private ProductRepo productRepo;

    public ShopService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> listProducts(){
        List<Product> allProducts = productRepo.list();

        return allProducts;
    }

    public Product getProduct(String id){
        Product foundProduct = productRepo.get(id);

        return foundProduct;
    }


}
