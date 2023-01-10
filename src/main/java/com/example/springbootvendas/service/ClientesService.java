package com.example.springbootvendas.service;

import com.example.springbootvendas.model.Cliente;
import com.example.springbootvendas.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {
    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){

    }

}
