package com.luv2code.springboot.inventorysystem.controller;

import com.luv2code.springboot.inventorysystem.service.CategoryService;
import com.luv2code.springboot.inventorysystem.entity.Category;
import com.luv2code.springboot.inventorysystem.entity.Item;
import com.luv2code.springboot.inventorysystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/category/{catId}/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    private String itemForm = "item-form";

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String findAll(@PathVariable("catId") int id, Model model){
       Category category = categoryService.findById(id);
       List<Item> itemList = category.getItems();

        model.addAttribute("category",category);
        model.addAttribute("items",itemList);
       return "item-list";
    }

    @GetMapping("/addItemForm")
    public String addItemForm(Model model,@PathVariable("catId") int id){
        Item item = new Item();
        model.addAttribute("catId",id);
        model.addAttribute("item",item);

        return itemForm;
    }

    @PostMapping("/addItem")
    public String addItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult,@PathVariable("catId") int catId){

        if(bindingResult.hasErrors())
            return itemForm;

        categoryService.addItem(catId,item);

        return "redirect:/category/"+catId+"/item/list";
    }

    @GetMapping("/updateItemForm")
    public String updateItemForm(@RequestParam("itemId") int theId,Model model,@PathVariable("catId") int catId){

        Item item = itemService.findById(theId);
        model.addAttribute("item",item);
        model.addAttribute("catId",catId);
        return itemForm;

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId,@PathVariable("catId") int catId){
        itemService.deleteById(theId);
        return "redirect:/category/"+catId+"/item/list";
    }


}
