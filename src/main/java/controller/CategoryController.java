package controller;

import exceptions.ItemNotFoundException;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/CategryController")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/InsertCategry")
    public void insertCategory(@RequestBody Category category) {
        categoryService.save(category);
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
        categoryService.save(category);
    }

    @DeleteMapping("/DeleteCategry")
    public void delete(@RequestParam int id) {
        categoryService.deleteById(id);
    }
}