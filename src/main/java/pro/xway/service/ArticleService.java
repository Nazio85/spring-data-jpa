package pro.xway.service;

import org.springframework.stereotype.Service;
import pro.xway.model.Article;
import pro.xway.model.Category;
import pro.xway.model.Company;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {
    void addArticle(Article article);
    void deleteArticle(Article article);
    Optional<Article> findArticleById(Long id);
    List<Article> findAll();
    List<Article> findAllByCategory(Category category);
    List<Article> findAllByCategory(Long categoryId);



}
