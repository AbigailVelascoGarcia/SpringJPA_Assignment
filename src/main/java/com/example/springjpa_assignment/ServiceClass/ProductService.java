package com.example.springjpa_assignment.ServiceClass;

import com.example.springjpa_assignment.Entity.Product;
import com.example.springjpa_assignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public void insertProduct(Product product){
        boolean productExists = productRepo.existsById(product.getProduct_id());

        if(productExists){
            product.setInventory_amount(product.getInventory_amount() + 1);

            try {
                productRepo.save(product);
            }catch (Exception e){
                throw new RuntimeException("Failed to update product");
            }
        }
        else{
            product.setInventory_amount(1);
            productRepo.save(product);
        }
    }
    public void updateProduct(Product product, Double price, byte[] image, String description, Integer inventory_amount){

        if (price != null){
            product.setPrice(price);
        } else if (image != null){
            product.setImage(image);
        } else if (description != null) {
            product.setDescription(description);
        } else if (inventory_amount != null) {
            product.setInventory_amount(inventory_amount);
        }

        productRepo.save(product);
    }

    public void deleteProduct(int product_id){
        Product product = productRepo.findById(product_id).get();
        product.setStatus(false);
        try{
            productRepo.save(product);
        } catch(Exception e){
            throw new IllegalArgumentException("Product not found");
        }
    }

    public List<Product> getAllProducts(){

        return (List<Product>) productRepo.findAll();
    }

    public Product getProductByName(String name){
        return productRepo.findByName(name);
    }

    public List<Product> getProductsByPrice(Double price){
        return (List<Product>) productRepo.findByPrice(price);
    }

}
