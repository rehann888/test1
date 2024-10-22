package com.reyhan.test1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.reyhan.test1.Entity.Product;
import com.reyhan.test1.Repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Page<Product> getAllProducts(int page, int size) {
        return productRepo.findAll(PageRequest.of(page, size));
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
}
