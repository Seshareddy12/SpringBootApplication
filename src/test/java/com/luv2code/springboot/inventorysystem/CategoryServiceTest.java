package com.luv2code.springboot.inventorysystem;


import com.luv2code.springboot.inventorysystem.dao.CategoryDAO;
import com.luv2code.springboot.inventorysystem.entity.Category;
import com.luv2code.springboot.inventorysystem.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryDAO categoryDAO;

    @Test
    public void getCategoriesTest(){
         when(categoryDAO.findAll()).thenReturn(Stream.of(new Category("Mobiles","Mobile description",null),new Category("Medicines","Medicines at discount price",null)).collect(Collectors.toList()));
         assertEquals(2,categoryService.findAll().size());
    }

    @Test
    public void getCategoryTest(){
        when(categoryDAO.findById(1)).thenReturn(new Category("Phone","Mobile description",null));
        assertEquals("Phone",categoryDAO.findById(1).getName());
    }

    @Test
    public void saveCategoryTest(){

            Category category = new Category("Marbles","Marble description",null);

            categoryService.save(category);

            verify(categoryDAO, times(1)).save(category);


    }

    @Test
    public void deleteCategoryTest(){
        int id=2;
        categoryService.deleteById(id);
        verify(categoryDAO,times(1)).deleteById(id);
    }

}
