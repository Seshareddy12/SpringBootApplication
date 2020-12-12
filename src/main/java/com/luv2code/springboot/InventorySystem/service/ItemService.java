package com.luv2code.springboot.InventorySystem.service;

import com.luv2code.springboot.InventorySystem.entity.Item;

public interface ItemService {
    public Item findById(int id);
    public void save(Item item);
    public void deleteById(int id);
}
