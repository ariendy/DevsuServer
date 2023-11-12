package com.devsu.dtos;

import com.devsu.model.Cliente;

public class UsuarioDTO {
    private Long personaId;

    private String identificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private String genero;
    private Integer edad;
    private Boolean estado;


    public static UsuarioDTO fromCliente(Cliente cliente) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPersonaId(cliente.getPersonaId());
        usuarioDTO.setContrasenia(cliente.getContrasenia());
        usuarioDTO.setEstado(cliente.getEstado());
        usuarioDTO.setDireccion(cliente.getDireccion());
        usuarioDTO.setTelefono(cliente.getTelefono());
        usuarioDTO.setNombre(cliente.getNombre());
        usuarioDTO.setGenero(cliente.getGenero());
        usuarioDTO.setEdad(cliente.getEdad());
        usuarioDTO.setIdentificacion(cliente.getIdentificacion());
        return usuarioDTO;
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setContrasenia(this.contrasenia);
        cliente.setEstado(this.estado);
        cliente.setDireccion(this.direccion);
        cliente.setTelefono(this.telefono);
        cliente.setPersonaId(this.personaId);
        cliente.setNombre(this.nombre);
        cliente.setGenero(this.genero);
        cliente.setEdad(this.edad);
        cliente.setIdentificacion(this.identificacion);
        return cliente;
    }

    public Long getPersonaId() {
        return personaId;
    }
    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
