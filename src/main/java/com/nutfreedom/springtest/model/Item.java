package com.nutfreedom.springtest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@NoArgsConstructor
@Data
public class Item {
    @Id
    private int id;
    private String name;
    private double price;
    private int quantity;
    @Transient
    private double value;

    public Item(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
