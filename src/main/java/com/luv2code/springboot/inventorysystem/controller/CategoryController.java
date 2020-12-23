package com.luv2code.springboot.inventorysystem.controller;


import com.luv2code.springboot.inventorysystem.entity.Category;
import com.luv2code.springboot.inventorysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

   
    private String categoryForm = "category-form";
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String getCategories(Model model){


        model.addAttribute("categories",categoryService.findAll());
        return "category-list";
    }

    @GetMapping("/addCategoryForm")
    public String addCategoryForm(Model theModel){
        theModel.addAttribute("category",new Category());
        return categoryForm;
    }

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult theBindingResult){
        if(theBindingResult.hasErrors())
            return categoryForm;
        categoryService.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/updateCategoryForm")
    public String updateCategory(@RequestParam("Id") int id,Model theModel){
        Category category = categoryService.findById(id);
        theModel.addAttribute("category",category);
        return categoryForm;
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("Id") int id){
        categoryService.deleteById(id);
        return "redirect:/category/list";
    }


}