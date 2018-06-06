package pro.xway.service;

import org.springframework.beans.factory.annotation.Autowired;
import pro.xway.dao.ArticleRepository;
import pro.xway.model.Article;
import pro.xway.model.Category;

import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository repository;

    @Override
    public void addArticle(Article article) {
        repository.save(article);
    }

    @Override
    public void deleteArticle(Article article) {
        repository.delete(article);
    }

    @Override
    public Optional<Article> findArticleById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Article> findAllByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public List<Article> findAllByCategory(Long categoryId) {
        return repository.findAllByCategory(categoryId);
    }




}
