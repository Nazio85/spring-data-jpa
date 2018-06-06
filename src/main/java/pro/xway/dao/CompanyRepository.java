package pro.xway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.xway.model.Article;
import pro.xway.model.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByArticles(Article article);
    Optional<Company> findCompanyByArticles(Long id);
}
