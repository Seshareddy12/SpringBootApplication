package com.luv2code.springboot.InventorySystem.controller;


import com.luv2code.springboot.InventorySystem.entity.Category;
import com.luv2code.springboot.InventorySystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

   
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String getCategories(Model model){


        model.addAttribute("categories",categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/addCategoryForm")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "category-form";
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult theBindingResult){
        if(theBindingResult.hasErrors())
            return "category-form";
        categoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/updateCategoryForm")
    public String updateCategory(@RequestParam("Id") int Id,Model theModel){
        Category category = categoryService.findById(Id);
        theModel.addAttribute("category",category);
        return "category-form";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("Id") int Id){
        categoryService.deleteById(Id);
        return "redirect:/category/list";
    }


}