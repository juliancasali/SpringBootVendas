package com.example.springbootvendas;

import com.example.springbootvendas.entity.Cliente;
import com.example.springbootvendas.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            System.out.println("Salvando clientes: ");
            clientes.save(new Cliente("julian"));
            clientes.save(new Cliente("Lucia"));


            System.out.println("Buscando cliente:");
            List<Cliente> result = clientes.findByNameLike("Lucia");
            result.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);
    }
}
