package com.example.actividad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actividad3.model.Cuestionario;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
    // El <Cuestionario, Long> indica la Entidad que maneja y el tipo de dato de su Llave Primaria (ID).
}