package repository;

import model.CategoryElements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryElementRepository extends JpaRepository<CategoryElements, Integer> {}
