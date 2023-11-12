package com.devsu.service;

import com.devsu.dtos.UsuarioDTO;
import com.devsu.exception.NotFoundException;
import com.devsu.exception.ServiceException;
import com.devsu.model.Cliente;
import com.devsu.repository.ClienteDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class UsuarioService {

    private final ClienteDao clienteDao;

    public UsuarioService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> getAllUsuarios() {
        return clienteDao.findAll().stream().map(UsuarioDTO::fromCliente).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO getUsuarioById(Long id) {
        return clienteDao.findById(id)
                .map(UsuarioDTO::fromCliente)
                .orElseThrow(() -> new NotFoundException("Cliente no encontrado."));
    }

    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        validateUsuario(usuarioDTO);
        Cliente cliente = usuarioDTO.toCliente();
        cliente = clienteDao.save(cliente);
        return UsuarioDTO.fromCliente(cliente);
    }

    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
        validateUsuario(usuarioDTO);
        Cliente cliente = usuarioDTO.toCliente();
        cliente = clienteDao.save(cliente);
        return UsuarioDTO.fromCliente(cliente);
    }

    public void deleteUsuario(Long id) {
        clienteDao.deleteById(id);
    }

    private void validateUsuario(UsuarioDTO usuarioDTO) {
        Objects.requireNonNull(usuarioDTO);

        if(usuarioDTO.getIdentificacion() == null || "".equals(usuarioDTO.getIdentificacion())) {
            throw new ServiceException("La identificación no pude estar en blanco.");
        }

        if(usuarioDTO.getNombre() == null || "".equals(usuarioDTO.getNombre())) {
            throw new ServiceException("El nombre no pude estar en blanco.");
        }

        clienteDao.findFirstByIdentificacion(usuarioDTO.getIdentificacion()).ifPresent(u -> {
            if(usuarioDTO.getPersonaId() == null || !Objects.equals(u.getPersonaId(), usuarioDTO.getPersonaId())) {
                throw new ServiceException("Esta identificación ya esta registrado.");
            }
        });
    }
}
