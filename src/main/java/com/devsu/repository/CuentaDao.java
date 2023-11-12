package com.devsu.repository;

import com.devsu.model.Cliente;
import com.devsu.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaDao extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findFirstByNumeroCuenta(String numeroCuenta);
}
