package com.luv2code.springboot.InventorySystem.service;

import com.luv2code.springboot.InventorySystem.dao.CategoryDAO;
import com.luv2code.springboot.InventorySystem.entity.Category;
import com.luv2code.springboot.InventorySystem.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;


    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    @Transactional
    public Category findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        categoryDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void addItem(int catId, Item item) {
        categoryDAO.addItem(catId,item);
    }
}
