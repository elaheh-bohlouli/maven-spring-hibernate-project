package service.serviceClass;

import model.CategoryElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryElementRepository;
import service.CategoryElementService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryElementServiceClass implements CategoryElementService {

    @Autowired
    private CategoryElementRepository categoryElementRepository;
    @Autowired
    private CategoryElements categoryElements;


    @Override
    public void create(CategoryElements categoryElement) {
        categoryElementRepository.save(categoryElement);
    }

    @Override
    public Optional<CategoryElements> findById(int id) {
        return categoryElementRepository.findById(id);
    }

    @Override
    public Optional<CategoryElements> findByRole(String role) {
        return categoryElementRepository.findOne(categoryElements.getRole().equals(role));
    }

    @Override
    public List<CategoryElements> findAll() {
        return categoryElementRepository.findAll();
    }

    @Override
    public void delete(CategoryElements categoryElements) {
        categoryElementRepository.delete(categoryElements);
    }

    @Override
    public void update(CategoryElements categoryElements) {
        categoryElementRepository.save(categoryElements);
    }
}