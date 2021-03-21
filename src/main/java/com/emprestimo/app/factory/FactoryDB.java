package com.emprestimo.app.factory;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;

@Getter
@Named
public class FactoryDB {

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String pass;

}
