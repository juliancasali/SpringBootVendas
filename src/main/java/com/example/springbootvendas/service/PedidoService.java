package com.example.springbootvendas.service;


import com.example.springbootvendas.domain.entity.Pedido;
import com.example.springbootvendas.rest.dto.PedidoDTO;

public interface PedidoService{
    Pedido salvar(PedidoDTO dto);
}
