package com.SpringCloud.Spring_Cloud_inventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}
