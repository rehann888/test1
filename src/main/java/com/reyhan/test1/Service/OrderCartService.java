package com.reyhan.test1.Service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import com.reyhan.test1.Entity.OrderCart;
import com.reyhan.test1.Entity.Product;
import com.reyhan.test1.Repository.OrderCartRepo;
import com.reyhan.test1.Repository.ProductRepo;

@Service
public class OrderCartService {

    @Autowired
    private OrderCartRepo orderCartRepo;    

    @Autowired
    private ProductRepo productRepo;

    public OrderCart saveOrderCart(OrderCart orderCart) {
        List<Product> existingProducts = orderCart.getProducts().stream()
            .map(product -> productRepo.findById(product.getId())) 
            .filter(Optional::isPresent) 
            .map(Optional::get) 
            .collect(Collectors.toList()); 

        existingProducts.forEach(product -> product.setOrderCart(orderCart));
        orderCart.setProducts(existingProducts);
        return orderCartRepo.save(orderCart);
    }

    public Optional<OrderCart> getOrderCartById(Long id) {
        return orderCartRepo.findById(id);
    }
    
}
