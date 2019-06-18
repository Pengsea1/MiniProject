package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {
    @Bean
    @Profile("dataBase")
    public DataSource Production() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("org.postgresql.Driver");
        db.setUrl("jdbc:postgresql://sun.awt.windows.awtLocalization:5432");
        return db;
    }
    @Bean
    @Profile("del")
    public DataSource development() {
        EmbeddedDatabaseBuilder db= new EmbeddedDatabaseBuilder();
        db.setType(EmbeddedDatabaseType.H2);
        db.addScript("sql/table.sql");
        return db.build();
    }
}
