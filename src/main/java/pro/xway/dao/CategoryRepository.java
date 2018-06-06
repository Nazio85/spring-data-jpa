package pro.xway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.xway.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
