package com.luv2code.springboot.inventorysystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id")
    private List<Item> items;

    public Category(@NotBlank(message = "is required") String name, @NotBlank(message = "is required") String description, List<Item> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    public void add(Item tempItem) {

        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(tempItem);


    }
}
