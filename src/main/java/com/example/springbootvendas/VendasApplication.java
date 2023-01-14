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
            clientes.save(new Cliente(null,"julian"));
            clientes.save(new Cliente(null,"Lucia"));

            List<Cliente> selectAll = clientes.selectAll();
            selectAll.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);

    }
}
