package com.java.socket.io.pypisan.configuration;

// import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import java.util.Properties;

import javax.sql.DataSource;

@Configuration
// @PropertySource(value = { "classpath:application.properties" })
public class JpaConfig {


    // @Value("${spring.datasource.url}")
    // public String url;

    // @Value("${spring.datasource.username}")
    // public String username;

    // @Value("${spring.datasource.password}")
    // public String password;

    // @Value("${spring.jpa.properties.hibernate.dialect}")
    // public String dialect;

    // @Value("${spring.jpa.hibernate.ddl-auto}")
    // public String ddl;

    // @Value("${spring.datasource.driver-class-name}")
    // public String driver;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // System.out.println(url);
        dataSource.setDriverClassName("org.postgresql.Driver"); // Change based on your database
        dataSource.setUrl("jdbc:postgresql://localhost:5400/test");
        dataSource.setUsername("user");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.java.socket.io.pypisan"); // Specify your package containing entities
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // Change dialect based on your database
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // Use "validate" or "none" in production

        emf.setJpaProperties(jpaProperties);
        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;
    }
}

