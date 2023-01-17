package com.example.springbootvendas.repository;

import com.example.springbootvendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente,Integer> {
    List<Cliente> findByNameLike(String name);
}
