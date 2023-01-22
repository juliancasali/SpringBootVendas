package com.example.springbootvendas.repository;

import com.example.springbootvendas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
