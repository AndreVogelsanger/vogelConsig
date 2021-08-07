package com.emprestimo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.emprestimo")
public class EmprestimoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmprestimoAppApplication.class, args);
	}

}
