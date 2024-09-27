package com.apprh.apprh.config;

import io.github.cdimascio.dotenv.Dotenv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();  // Carrega as variáveis do .env
    }

    @Bean
    public DataSource dataSource(Dotenv dotenv) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dotenv.get("DB_URL"));
        dataSource.setUsername(dotenv.get("DB_USERNAME"));
        dataSource.setPassword(dotenv.get("DB_PASSWORD"));
        return dataSource;
    }
}