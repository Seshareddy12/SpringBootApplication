package com.luv2code.springboot.inventorysystem;


import com.luv2code.springboot.inventorysystem.dao.CategoryDAO;
import com.luv2code.springboot.inventorysystem.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDAOTest {
    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    @Transactional
    @Rollback(true)
    public void testAddCategory(){
        Category category = new Category("abc","abc description",null);
        categoryDAO.save(category);
        List<Category> categories = categoryDAO.findAll();
        Assert.assertEquals(category.getName(),categories.get(categories.size()-1).getName());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindById(){
        Category category = new Category("lmnop","abc description",null);
        category.setId(20);
        categoryDAO.save(category);
        Category categoryRetrieved = categoryDAO.findById(20);
        Assert.assertEquals(category.getName(),categoryRetrieved.getName());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCategory(){
        Category category = new Category("lmnop","abc description",null);
        category.setId(20);
        categoryDAO.save(category);
        Category categoryUpdated = categoryDAO.findById(20);
        categoryUpdated.setName("qwerty");
        categoryDAO.save(category);
        Category categoryRetrieved = categoryDAO.findById(20);
        Assert.assertEquals("qwerty",categoryRetrieved.getName());



    }

    @Test
    @Transactional
    @Rollback(true)
    public void testDeleteCategory(){
        List<Category> categories = categoryDAO.findAll();
        int id = categories.get(0).getId();
        int size = categories.size();

        categoryDAO.deleteById(id);


        List<Category> categoriesRetrieved = categoryDAO.findAll();
        Assert.assertEquals(size-1,categoriesRetrieved.size());



    }




}
