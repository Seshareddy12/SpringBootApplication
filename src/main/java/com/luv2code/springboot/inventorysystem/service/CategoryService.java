package com.luv2code.springboot.inventorysystem.service;

import com.luv2code.springboot.inventorysystem.entity.Category;
import com.luv2code.springboot.inventorysystem.entity.Item;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category findById(int id);
    public void save(Category category);
    public void deleteById(int id);
    public void addItem(int catId, Item item);
}
