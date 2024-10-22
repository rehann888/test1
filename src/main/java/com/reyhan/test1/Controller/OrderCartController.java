package com.reyhan.test1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reyhan.test1.Entity.OrderCart;
import com.reyhan.test1.Service.OrderCartService;

@RestController
@RequestMapping("api/ordercart")
public class OrderCartController {

    @Autowired
    private OrderCartService orderCartService;

    @PostMapping
    public ResponseEntity<OrderCart> createOrderCart(@RequestBody OrderCart orderCart) {
        OrderCart savedOrderCart = orderCartService.saveOrderCart(orderCart);
        return ResponseEntity.ok(savedOrderCart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderCart> getOrderCart(@PathVariable Long id) {
        return orderCartService.getOrderCartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
