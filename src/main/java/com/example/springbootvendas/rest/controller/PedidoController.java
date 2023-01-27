package com.example.springbootvendas.rest.controller;

import com.example.springbootvendas.domain.entity.Pedido;
import com.example.springbootvendas.rest.dto.PedidoDTO;
import com.example.springbootvendas.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = service.salvar(pedidoDTO);
        return pedido.getId();
    }





}
