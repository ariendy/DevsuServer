package com.devsu.repository;

import com.devsu.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaDao {}/*extends JpaRepository<Persona, Long> {
    Optional<Persona> findByPersonaId(Long id);
}
*/
