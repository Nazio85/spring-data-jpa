package pro.xway.service;

import org.springframework.beans.factory.annotation.Autowired;
import pro.xway.dao.CompanyRepository;
import pro.xway.model.Article;
import pro.xway.model.Company;

import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;


    @Override
    public Optional<Company> findCompanyById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Company> findCompanyByArticle(Article article) {
        return repository.findCompanyByArticles(article);
    }

    @Override
    public Optional<Company> findCompanyByArticle(Long companyId) {
        return repository.findCompanyByArticles(companyId);
    }

}
