package com.luv2code.springboot.InventorySystem.dao;

import com.luv2code.springboot.InventorySystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
