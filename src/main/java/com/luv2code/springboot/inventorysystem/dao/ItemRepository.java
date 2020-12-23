package com.luv2code.springboot.inventorysystem.dao;

import com.luv2code.springboot.inventorysystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
