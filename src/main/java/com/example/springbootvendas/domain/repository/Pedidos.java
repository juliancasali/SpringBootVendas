package com.example.springbootvendas.domain.repository;

import com.example.springbootvendas.domain.entity.Cliente;
import com.example.springbootvendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
