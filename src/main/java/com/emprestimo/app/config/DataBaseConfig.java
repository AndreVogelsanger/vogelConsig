package com.emprestimo.app.config;


import com.emprestimo.app.factory.FactoryDB;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
@Named
@AllArgsConstructor(onConstructor = @__(@Inject))
public class DataBaseConfig {

    public static final String DS_DATABASE = "DS_DATABASE";
    public static final String JDBC_DATABASE = "JDBC_DATABASE";

    private final FactoryDB factoryDB;

    @Bean
    @Named(DS_DATABASE)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .username(factoryDB.getUser())
                .password(factoryDB.getPass())
                .build();
    }

    @Bean
    @Named(JDBC_DATABASE)
    public JdbcTemplate jdbcTemplate(@Named(DS_DATABASE) DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
