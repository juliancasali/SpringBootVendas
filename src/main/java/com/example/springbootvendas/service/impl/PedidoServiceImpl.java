package com.example.springbootvendas.service.impl;

import com.example.springbootvendas.domain.repository.Pedidos;
import com.example.springbootvendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidos;

    public PedidoServiceImpl(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
