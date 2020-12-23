package com.luv2code.springboot.inventorysystem.service;

import com.luv2code.springboot.inventorysystem.entity.Item;

public interface ItemService {
    public Item findById(int id);
    public void save(Item item);
    public void deleteById(int id);
}
