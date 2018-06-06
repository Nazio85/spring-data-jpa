package pro.xway.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@PropertySource("classpath:db-config.properties")
public class DataSourceConfiguration {

    @Bean("dataSource")
    public DataSource dataSource(@Value("${datasource.driver}") String dataSourceDriver,
                                 @Value("${datasource.url}") String dataSourceUrl,
                                 @Value("${datasource.user}") String dataSourceUser,
                                 @Value("${datasource.password}") String dataSourcePassword){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSourceDriver);
        driverManagerDataSource.setUrl(dataSourceUrl);
        driverManagerDataSource.setUsername(dataSourceUser);
        driverManagerDataSource.setPassword(dataSourcePassword);
        return driverManagerDataSource;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource,
                                                                       @Value("${hibernate.max_fetch_depth}") int maxFetchDepth,
                                                                       @Value("${hibernate.jdbc.fetch_size}") int fetchSize,
                                                                       @Value("${hibernate.jdbc.batch_size}") int batchSize,
                                                                       @Value("${hibernate.show_sql}") boolean showSql,
                                                                       @Value("${hibernate.hbm2ddl.auto}") String tableStrategy) {
        // Создание класса фабрики, реализующей интерфейс FactoryBean<EntityManagerFactory>
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("pro.xway.model");
        Properties properties = new Properties();
        properties.put("hibernate.max_fetch_depth", maxFetchDepth);
        properties.put("hibernate.jdbc.fetch_size", fetchSize);
        properties.put("hibernate.jdbc.batch_size", batchSize);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hbm2ddl.auto", tableStrategy);
        factoryBean.setJpaProperties(properties);
        return factoryBean;
    }

    @Bean("transactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
