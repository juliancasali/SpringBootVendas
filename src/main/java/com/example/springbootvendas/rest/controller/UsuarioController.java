package com.example.springbootvendas.rest.controller;

import com.example.springbootvendas.domain.entity.Usuario;
import com.example.springbootvendas.service.impl.UsuarioServiceImpl;
import static org.springframework.http.HttpStatus.*;

import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioServiceImpl usuarioService;

    private PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioService.salvar(usuario);
    }
}
