package com.example.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.example.hibernate")
public class Config {

    @Bean
    public EntityManager entityManager() {
        EntityManagerFactory factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        return factory.createEntityManager();
    }
}
