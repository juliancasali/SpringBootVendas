package com.example.springbootvendas.domain.repository;

import com.example.springbootvendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
