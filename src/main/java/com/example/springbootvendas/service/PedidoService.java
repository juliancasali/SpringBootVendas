package com.example.springbootvendas.service;


import com.example.springbootvendas.domain.entity.Pedido;
import com.example.springbootvendas.domain.enums.StatusPedido;
import com.example.springbootvendas.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService{

    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
