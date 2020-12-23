package com.luv2code.springboot.inventorysystem.service;

import com.luv2code.springboot.inventorysystem.dao.ItemRepository;
import com.luv2code.springboot.inventorysystem.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findById(int id) {
         Optional<Item> optionalItem = itemRepository.findById(id);
         if(!optionalItem.isPresent())
         {
             throw new IllegalArgumentException("Wrong Id");
         }
         return optionalItem.get();
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
