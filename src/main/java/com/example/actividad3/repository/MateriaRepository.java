package com.example.actividad3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.actividad3.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    // Al heredar de JpaRepository, ya tenemos métodos como:
    // save(), findAll(), findById(), deleteById() automáticamente.
}