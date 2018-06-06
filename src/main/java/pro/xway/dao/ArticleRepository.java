package pro.xway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.xway.model.Article;
import pro.xway.model.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategory(Category category);
    List<Article> findAllByCategory(Long categoryId);
}
