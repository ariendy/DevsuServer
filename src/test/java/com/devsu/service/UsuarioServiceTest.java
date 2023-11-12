package com.devsu.service;

import com.devsu.dtos.UsuarioDTO;
import com.devsu.exception.ServiceException;
import com.devsu.model.Cliente;
import com.devsu.repository.ClienteDao;
import com.devsu.util.UsuarioHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


public class UsuarioServiceTest {

    private ClienteDao clienteDao;
    private UsuarioService usuarioService;

    private List<Cliente> mockClientes;

    @BeforeEach
    void setUp() {
        clienteDao = Mockito.mock(ClienteDao.class);
        mockClientes = UsuarioHelper.generateClientes();
        usuarioService = new UsuarioService(clienteDao);
    }

    @Test
    @DisplayName("Debería buscar todos los usuarios.")
    void shouldGetAllUsuarios() {
        Mockito.when(clienteDao.findAll()).thenReturn(mockClientes);
        List<UsuarioDTO> responseUsuarioDTOs = usuarioService.getAllUsuarios();
        Assertions.assertThat(responseUsuarioDTOs).isNotNull();
        Assertions.assertThat(responseUsuarioDTOs).isNotEmpty();
        Assertions.assertThat(responseUsuarioDTOs.get(0).getPersonaId()).isEqualTo(mockClientes.get(0).getPersonaId());
        Assertions.assertThat(responseUsuarioDTOs.get(1).getPersonaId()).isEqualTo(mockClientes.get(1).getPersonaId());
        Assertions.assertThat(responseUsuarioDTOs.get(2).getPersonaId()).isEqualTo(mockClientes.get(2).getPersonaId());
    }

    @Test
    @DisplayName("Debería buscar el usuario por ID.")
    void shouldGetUsuarioById() {
        Mockito.when(clienteDao.findById(123L)).thenReturn(Optional.ofNullable(mockClientes.get(0)));
        UsuarioDTO responseUsuarioDTO = usuarioService.getUsuarioById(123L);
        Assertions.assertThat(responseUsuarioDTO).isNotNull();
        Assertions.assertThat(responseUsuarioDTO.getPersonaId()).isEqualTo(mockClientes.get(0).getPersonaId());
        Assertions.assertThat(responseUsuarioDTO.getIdentificacion()).isEqualTo(mockClientes.get(0).getIdentificacion());
        Assertions.assertThat(responseUsuarioDTO.getNombre()).isEqualTo(mockClientes.get(0).getNombre());
        Assertions.assertThat(responseUsuarioDTO.getTelefono()).isEqualTo(mockClientes.get(0).getTelefono());
        Assertions.assertThat(responseUsuarioDTO.getEstado()).isEqualTo(mockClientes.get(0).getEstado());
    }

    @Test
    @DisplayName("Debería guardar el usuario.")
    void shouldSaveUsuario() {
        Mockito.when(clienteDao.save(any())).thenReturn(mockClientes.get(0));
        UsuarioDTO responseUsuarioDTO = usuarioService.saveUsuario(UsuarioHelper.generateNewUsuarioDTO());
        Assertions.assertThat(responseUsuarioDTO).isNotNull();
        Assertions.assertThat(responseUsuarioDTO.getPersonaId()).isEqualTo(mockClientes.get(0).getPersonaId());
        Assertions.assertThat(responseUsuarioDTO.getIdentificacion()).isEqualTo(mockClientes.get(0).getIdentificacion());
        Assertions.assertThat(responseUsuarioDTO.getNombre()).isEqualTo(mockClientes.get(0).getNombre());
        Assertions.assertThat(responseUsuarioDTO.getTelefono()).isEqualTo(mockClientes.get(0).getTelefono());
        Assertions.assertThat(responseUsuarioDTO.getEstado()).isEqualTo(mockClientes.get(0).getEstado());
    }

    @Test
    @DisplayName("Deberia actualizar usuario.")
    void shouldUpdateUsuario() {
        Mockito.when(clienteDao.save(any())).thenReturn(mockClientes.get(0));
        UsuarioDTO responseUsuarioDTO = usuarioService.updateUsuario(UsuarioHelper.generateNewUsuarioDTO());
        Assertions.assertThat(responseUsuarioDTO).isNotNull();
        Assertions.assertThat(responseUsuarioDTO.getPersonaId()).isEqualTo(mockClientes.get(0).getPersonaId());
        Assertions.assertThat(responseUsuarioDTO.getIdentificacion()).isEqualTo(mockClientes.get(0).getIdentificacion());
        Assertions.assertThat(responseUsuarioDTO.getNombre()).isEqualTo(mockClientes.get(0).getNombre());
        Assertions.assertThat(responseUsuarioDTO.getTelefono()).isEqualTo(mockClientes.get(0).getTelefono());
        Assertions.assertThat(responseUsuarioDTO.getEstado()).isEqualTo(mockClientes.get(0).getEstado());
        Assertions.assertThat(responseUsuarioDTO.getEstado()).isEqualTo(mockClientes.get(0).getEstado());
    }

    @Test
    @DisplayName("No debería tener el nombre en blanco.")
    void shouldNotBeEmptyNombreSaveUsuario() {
        Mockito.when(clienteDao.save(any())).thenReturn(mockClientes.get(0));
        UsuarioDTO usuarioDTOToBeSaved = UsuarioHelper.generateNewUsuarioDTO();
        usuarioDTOToBeSaved.setNombre(null);
        assertThrows(ServiceException.class, () -> usuarioService.saveUsuario(usuarioDTOToBeSaved), "El nombre no pude estar en blanco.");
    }

    @Test
    @DisplayName("No debería tener la identificación en blanco.")
    void shouldNotBeEmptyIdentificacionSaveUsuario() {
        Mockito.when(clienteDao.save(any())).thenReturn(mockClientes.get(0));
        UsuarioDTO usuarioDTOToBeSaved = UsuarioHelper.generateNewUsuarioDTO();
        usuarioDTOToBeSaved.setIdentificacion(null);
        assertThrows(ServiceException.class, () -> usuarioService.saveUsuario(usuarioDTOToBeSaved), "La identificación no pude estar en blanco.");
    }

}
