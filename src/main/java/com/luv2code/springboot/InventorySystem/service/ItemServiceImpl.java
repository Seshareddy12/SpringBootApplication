package com.luv2code.springboot.InventorySystem.service;

import com.luv2code.springboot.InventorySystem.dao.ItemRepository;
import com.luv2code.springboot.InventorySystem.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }
}
