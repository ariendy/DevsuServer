package com.devsu.util;

import com.devsu.dtos.UsuarioDTO;
import com.devsu.model.Cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioHelper {


    public Collection<UsuarioDTO> generateUsuarioDTOs() {
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersonaId(1L);
        usuarioDTO.setIdentificacion("Nombre 1");
        usuarioDTO.setGenero("M");
        usuarioDTO.setEdad(20);
        usuarioDTO.setDireccion("C/primera #25, sector 1");
        usuarioDTO.setTelefono("###-###-####");
        usuarioDTO.setContrasenia("123");
        usuarioDTO.setEstado(true);
        usuarioDTOs.add(usuarioDTO);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersonaId(2L);
        usuarioDTO.setIdentificacion("Nombre 2");
        usuarioDTO.setGenero("F");
        usuarioDTO.setEdad(28);
        usuarioDTO.setDireccion("C/segunda #25, sector 2");
        usuarioDTO.setTelefono("$$$-$$$-$$$");
        usuarioDTO.setContrasenia("456");
        usuarioDTO.setEstado(true);
        usuarioDTOs.add(usuarioDTO);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersonaId(3L);
        usuarioDTO.setIdentificacion("Nombre 3");
        usuarioDTO.setGenero("M");
        usuarioDTO.setEdad(48);
        usuarioDTO.setDireccion("C/tercera #25, sector 3");
        usuarioDTO.setTelefono("###-###-####");
        usuarioDTO.setContrasenia("789");
        usuarioDTO.setEstado(true);
        usuarioDTOs.add(usuarioDTO);

        return usuarioDTOs;
    }

    public static List<Cliente> generateClientes() {
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente();
        cliente.setPersonaId(1L);
        cliente.setIdentificacion("Identificacion 1");
        cliente.setNombre("Nombre 1");
        cliente.setGenero("M");
        cliente.setEdad(20);
        cliente.setDireccion("C/primera #25, sector 1");
        cliente.setTelefono("###-###-####");
        cliente.setContrasenia("123");
        cliente.setEstado(true);
        clientes.add(cliente);

        cliente = new Cliente();
        cliente.setPersonaId(2L);
        cliente.setIdentificacion("Identificacion 2");
        cliente.setNombre("Nombre 2");
        cliente.setGenero("F");
        cliente.setEdad(28);
        cliente.setDireccion("C/segunda #25, sector 2");
        cliente.setTelefono("$$$-$$$-$$$");
        cliente.setContrasenia("456");
        cliente.setEstado(true);
        clientes.add(cliente);

        cliente = new Cliente();
        cliente.setPersonaId(3L);
        cliente.setIdentificacion("Identificacion 3");
        cliente.setNombre("Nombre 3");
        cliente.setGenero("M");
        cliente.setEdad(48);
        cliente.setDireccion("C/tercera #25, sector 3");
        cliente.setTelefono("###-###-####");
        cliente.setContrasenia("789");
        cliente.setEstado(true);
        clientes.add(cliente);

        return clientes;
    }
    public static UsuarioDTO generateNewUsuarioDTO() {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersonaId(4L);
        usuarioDTO.setIdentificacion("Identificacion 4");
        usuarioDTO.setNombre("Nombre 4");
        usuarioDTO.setGenero("M");
        usuarioDTO.setEdad(26);
        usuarioDTO.setDireccion("C/cuarta #25, sector 4");
        usuarioDTO.setTelefono("%%%%-%%%-%%%%%");
        usuarioDTO.setContrasenia("147");
        usuarioDTO.setEstado(true);
        return usuarioDTO;
    }
}
