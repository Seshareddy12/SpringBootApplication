package com.luv2code.springboot.inventorysystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(name="item")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    private long createDate;

    @LastModifiedDate
    private long lastModifiedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;


    public Item( @NotBlank(message = "is required") String name, @Min(value = 0, message = "Value should be greater than or equal to zero") int price, @Min(value = 0, message = "Value should be greater than or equal to zero") int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


}
