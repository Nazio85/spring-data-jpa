package pro.xway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pro.xway.config.ApplicationConfig;
import pro.xway.dao.ArticleRepository;
import pro.xway.model.Article;
import pro.xway.model.Category;
import pro.xway.model.User;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Optional;

public class Application {

    @Autowired
    private ArticleRepository articleRepository;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ArticleRepository articleRepository = ctx.getBean("articleRepository", ArticleRepository.class);
        Optional<Article> articleOptional = articleRepository.findById(1L);

    }

}
