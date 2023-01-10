package com.example.springbootvendas.config;

import com.example.springbootvendas.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÂO DE DESENVOLVIMENTO");
        };
    }

}
