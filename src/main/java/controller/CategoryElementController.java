package controller;

import Commen.ItemNotFoundException;
import model.CategoryElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CategoryElementRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/CategryElementController")
public class CategoryElementController {

    private final CategoryElementRepository categoryElementRepository;

    @Autowired
    public CategoryElementController(CategoryElementRepository categoryElementRepository) {
        this.categoryElementRepository = categoryElementRepository;
    }


    @PostMapping("/InsertCategryElement")
    public void insertAskDayOff(@RequestBody CategoryElements categoryElements) {
        categoryElementRepository.save(categoryElements);
    }

    @GetMapping("/GetByIdCategryElement")
    public CategoryElements categoryElements(@RequestParam int id) throws ItemNotFoundException {
        return categoryElementRepository.findById(id).orElseThrow(() -> new ItemNotFoundException());
    }

    @GetMapping("/GetAllCategryElement")
    public List<CategoryElements> categoryElementList(){
        return categoryElementRepository.findAll();
    }

    @PostMapping("/UpdateCategryElement")
    public void update(@RequestBody CategoryElements categoryElements){
        categoryElementRepository.save(categoryElements);
    }

    @DeleteMapping("/DeleteCategryElement")
    public void delete(@RequestParam int id) {
        categoryElementRepository.deleteById(id);
    }
}
