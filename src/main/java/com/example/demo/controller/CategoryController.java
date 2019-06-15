package com.example.demo.controller;

import com.example.demo.repository.model.Category;
import com.example.demo.service.CategoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping("/categoryHome")
    String categoryHome(){
        return "redirect:/category";
    }
    @GetMapping("/category")
    String getCategory(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        System.out.println(categoryService.findAll());
        return "viewCategory";
    }

    @PostMapping("/updateCategory")
    String updateCategory(@ModelAttribute Category category, ModelMap modelMap) {
        modelMap.addAttribute("category", new Category(categoryService.getAutoId() + 1, ""));
        categoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("/updatecate")
    String view(@RequestParam int id, ModelMap modelMap) {
        modelMap.addAttribute("category", categoryService.findById(id));
        modelMap.addAttribute("st", -1);
        return "updateCate";
    }

    @GetMapping("/addCategory")
    String addNewCategory(ModelMap modelMap) {
        modelMap.addAttribute("category", new Category(categoryService.getAutoId() + 1, ""));
        return "updateCate";
    }

    @PostMapping("/addCategory")
    String AddNew(@ModelAttribute Category category) {
        categoryService.add(category);
        return "redirect:/category";
    }
    @GetMapping("/deletecate")
    String deleteCategory(@RequestParam Integer id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
