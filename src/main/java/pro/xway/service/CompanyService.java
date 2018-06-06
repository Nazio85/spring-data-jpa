package pro.xway.service;

import pro.xway.model.Article;
import pro.xway.model.Company;

import java.util.Optional;

public interface CompanyService {
    Optional<Company> findCompanyById(Long id);
    Optional<Company> findCompanyByArticle(Article article);
    Optional<Company> findCompanyByArticle(Long companyId);

}
