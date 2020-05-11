package controller;

import Commen.ItemNotFoundException;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/CategryController")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostMapping("/InsertCategry")
    public void insertCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @GetMapping("/GetByIdCategry")
    public Category category(@RequestParam int id) throws ItemNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategry")
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    @PostMapping("/UpdateCategry")
    public void update(@RequestBody Category category){
        categoryRepository.save(category);
    }

    @DeleteMapping("/DeleteCategry")
    public void delete(@RequestParam int id) {
        categoryRepository.deleteById(id);
    }
}
