package com.luv2code.springboot.InventorySystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @NotBlank(message = "is required")
    @Column(name="name")
    private String name;

    @NotBlank(message = "is required")
    @Column(name="description")
    private String description;

    @OneToMany(cascade = {CascadeType.MERGE},orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private List<Item> items;

    public Category(){

    }

    public Category(String name, String description, List<Item> items) {
        this.name = name;
        this.description = description;
        this.items = items;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item tempItem) {

        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(tempItem);


    }
}
