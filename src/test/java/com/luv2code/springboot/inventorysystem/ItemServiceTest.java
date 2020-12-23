package com.luv2code.springboot.inventorysystem;

import com.luv2code.springboot.inventorysystem.dao.ItemRepository;
import com.luv2code.springboot.inventorysystem.entity.Item;
import com.luv2code.springboot.inventorysystem.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @MockBean
    private ItemRepository itemRepository;

    @Test
    public void getItemTest(){
        when(itemRepository.findById(1)).thenReturn(java.util.Optional.of(new Item("Mobile", 300, 400)));
        assertEquals("Mobile",itemService.findById(1).getName());
    }


    @Test
    public void saveItemTest(){

        Item item = new Item("Marbles",900,0);

        itemService.save(item);

        verify(itemRepository, times(1)).save(item);


    }

    @Test
    public void deleteItemTest(){
       int id=2;

        itemService.deleteById(id);

        verify(itemRepository, times(1)).deleteById(id);

    }

}