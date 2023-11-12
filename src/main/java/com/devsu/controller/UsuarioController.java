package com.devsu.controller;

import com.devsu.dtos.UsuarioDTO;
import com.devsu.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO getUsuarioById(@PathVariable  Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.saveUsuario(usuarioDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO updateUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.updateUsuario(usuarioDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}
