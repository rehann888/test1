package com.reyhan.test1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reyhan.test1.Entity.OrderCart;

@Repository
public interface OrderCartRepo extends JpaRepository <OrderCart, Long> {

} 
