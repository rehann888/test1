package com.reyhan.test1.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class OrderCart implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @OneToMany(mappedBy = "orderCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();  

    @Transient
    private BigDecimal totalOrder;  

    @Column(name = "placed") 
    private boolean placed;

    public BigDecimal getTotalOrder() {
        if (products == null || products.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return products.stream()
                .map(Product::getItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}
