package com.luv2code.springboot.InventorySystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "is required")
    @Column(name="name")
    private String name;


    @Min(value = 0,message = "Value should be greater than or equal to zero")
    @Column(name="price")
    private int price;

    @Min(value = 0,message = "Value should be greater than or equal to zero")
    @Column(name="stock")
    private int stock;



    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;

    }

    public Item(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock;
    }
}
