package com.reyhan.test1.Entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    private BigDecimal price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_cart_id") 
    @JsonIgnore
    private OrderCart orderCart;  

    @Transient
    private BigDecimal itemTotal;

    public BigDecimal getItemTotal() {
        return price.multiply(new BigDecimal(quantity)); 
    }
}
