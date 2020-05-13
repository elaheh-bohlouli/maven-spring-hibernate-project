package repository;

import model.CategoryElements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryElementRepository extends JpaRepository<CategoryElements, Integer> {}
