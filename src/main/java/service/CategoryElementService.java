package service;

import model.CategoryElements;

import java.util.List;
import java.util.Optional;

public interface CategoryElementService {
    void create(CategoryElements categoryElements);
    Optional<CategoryElements> findById(int id);
    List<CategoryElements> findAll();
    void deleteById(int id);
    void update(CategoryElements categoryElements);
}
