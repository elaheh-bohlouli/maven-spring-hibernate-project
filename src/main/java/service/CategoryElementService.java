package service;

import model.CategoryElements;

import java.util.List;
import java.util.Optional;

public interface CategoryElementService {
    void create(CategoryElements categoryElements);
    Optional<CategoryElements> findById(int id);
    Optional<CategoryElements> findByRole(String role);
    List<CategoryElements> findAll();
    void delete(CategoryElements categoryElements);
    void update(CategoryElements categoryElements);
}
