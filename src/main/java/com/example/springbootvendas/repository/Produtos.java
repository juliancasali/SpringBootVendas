package com.example.springbootvendas.repository;

import com.example.springbootvendas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
