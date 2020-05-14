package com.ela.controller;

import com.ela.exceptions.ItemNotFoundException;
import com.ela.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ela.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/CategryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/InsertCategry")
    public void insertCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping("/GetByIdCategry")
    public Category category(@RequestParam int id) throws ItemNotFoundException {
        return categoryService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategry")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

    @PostMapping("/UpdateCategry")
    public void update(@RequestBody Category category){
        categoryService.update(category);
    }

    @DeleteMapping("/DeleteCategry")
    public void delete(@RequestParam int id) {
        categoryService.deleteById(id);
    }
}
