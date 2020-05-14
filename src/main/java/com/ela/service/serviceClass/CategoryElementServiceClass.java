package com.ela.service.serviceClass;

import com.ela.model.CategoryElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ela.repository.CategoryElementRepository;
import com.ela.service.CategoryElementService;

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
    public List<CategoryElements> findAll() {
        return categoryElementRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        categoryElementRepository.deleteById(id);
    }

    @Override
    public void update(CategoryElements categoryElements) {
        categoryElementRepository.save(categoryElements);
    }
}