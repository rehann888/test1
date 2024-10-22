package com.reyhan.test1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reyhan.test1.Entity.Product;

public interface ProductRepo extends JpaRepository <Product, Long> {

}
