package com.spring.boot.coffeine.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by jinz on 4/16/17.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.spring.boot.coffeine.dao",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
@PropertySource({"file:${app.config-path}/database.properties"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Value("${hikari.maximumPoolSize:10}")
    private int maxPoolSize;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "hikari")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSourceOracle() {

        DataSourceProperties dataSourceProperties = dataSourceProperties();
        HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
                .create(dataSourceProperties.getClassLoader())
                .driverClassName(dataSourceProperties.getDriverClassName())
                .url(dataSourceProperties.getUrl())
                .username(dataSourceProperties.getUsername())
                .password(dataSourceProperties.getPassword())
                .type(HikariDataSource.class)
                .build();
        dataSource.setMaximumPoolSize(maxPoolSize);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSourceOracle());
        factoryBean.setPackagesToScan(new String[]{"com.spring.boot.coffeine.dao.entity"});
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.default_schema", env.getRequiredProperty("hibernate.default_schema"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.connection.CharSet", env.getRequiredProperty("hibernate.connection.CharSet"));
        properties.put("hibernate.connection.characterEncoding", env.getRequiredProperty("hibernate.connection.characterEncoding"));
        properties.put("hibernate.connection.useUnicode", env.getRequiredProperty("hibernate.connection.useUnicode"));
        properties.put("hibernate.enable_lazy_load_no_trans", true);

        return properties;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}
