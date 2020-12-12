package com.luv2code.springboot.InventorySystem.controller;

import com.luv2code.springboot.InventorySystem.service.CategoryService;
import com.luv2code.springboot.InventorySystem.entity.Category;
import com.luv2code.springboot.InventorySystem.entity.Item;
import com.luv2code.springboot.InventorySystem.service.ItemService;
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

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String findAll(@PathVariable("catId") int id, Model model){
       Category category = categoryService.findById(id);
       List<Item> itemList = category.getItems();
        //System.out.println(itemList);
        model.addAttribute("category",category);
        model.addAttribute("items",itemList);
       return "item-list";
    }

    @GetMapping("/addItemForm")
    public String addItemForm(Model model,@PathVariable("catId") int id){
        Item item = new Item();
        model.addAttribute("catId",id);
        model.addAttribute("item",item);

        return "item-form";
    }

    @PostMapping("/addItem")
    public String addItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult,@PathVariable("catId") int catId){

        if(bindingResult.hasErrors())
            return "item-form";
        itemService.save(item);
        categoryService.addItem(catId,item);

        return "redirect:/category/"+catId+"/item/list";
    }

    @GetMapping("/updateItemForm")
    public String updateItemForm(@RequestParam("itemId") int theId,Model model,@PathVariable("catId") int catId){

        Item item = itemService.findById(theId);
        model.addAttribute("item",item);
        model.addAttribute("catId",catId);
        return "item-form";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId,@PathVariable("catId") int catId){
        itemService.deleteById(theId);
        return "redirect:/category/"+catId+"/item/list";
    }


}
