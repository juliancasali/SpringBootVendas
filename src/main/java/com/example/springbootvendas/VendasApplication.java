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
            clientes.save(new Cliente(null,"julian"));
            clientes.save(new Cliente(null,"Lucia"));

            List<Cliente> selectAll = clientes.selectAll();
            selectAll.forEach(System.out::println);

            System.out.println("Atualizando cliente");
            selectAll.forEach(c -> {c.setName(c.getName() + " atualizado");
            clientes.update(c);
            });

            selectAll = clientes.selectAll();
            if(selectAll.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }
            else {
                selectAll.forEach(System.out::println);
            }

            System.out.println("Buscando cliente:");
            clientes.findName("Lu").forEach(System.out::println);


            System.out.println("Deletando clientes:");
            clientes.selectAll().forEach(clientes::delete);

            selectAll = clientes.selectAll();
            if(selectAll.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }
            else {
                selectAll.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);

    }
}
