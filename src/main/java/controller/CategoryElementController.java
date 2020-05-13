package controller;

import exceptions.ItemNotFoundException;
import model.CategoryElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CategoryElementService;

import java.util.List;

@RestController
@RequestMapping(value = "/CategryElementController")
public class CategoryElementController {

    @Autowired
    private CategoryElementService categoryElementService;

    @PostMapping("/InsertCategryElement")
    public void insertCategoryElement(@RequestBody CategoryElements categoryElements) {
        categoryElementService.save(categoryElements);
    }

    @GetMapping("/GetByIdCategryElement")
    public CategoryElements categoryElements(@RequestParam int id) throws ItemNotFoundException {
        return categoryElementService.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategryElement")
    public List<CategoryElements> categoryElementList(){
        return categoryElementService.findAll();
    }

    @PostMapping("/UpdateCategryElement")
    public void update(@RequestBody CategoryElements categoryElements){
        categoryElementService.save(categoryElements);
    }

    @DeleteMapping("/DeleteCategryElement")
    public void delete(@RequestParam int id) {
        categoryElementService.deleteById(id);
    }
}
