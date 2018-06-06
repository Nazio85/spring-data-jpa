package pro.xway.service;

import org.springframework.beans.factory.annotation.Autowired;
import pro.xway.dao.CategoryRepository;
import pro.xway.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAllCategories() {
        return repository.findAll();
    }
}
