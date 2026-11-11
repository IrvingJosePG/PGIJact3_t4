package com.example.actividad3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad3.model.Cuestionario;
import com.example.actividad3.repository.CuestionarioRepository;

@Service
public class CuestionarioService {

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    // C (Create) y U (Update) - save() sirve para ambos en Spring Data JPA
    public Cuestionario guardar(Cuestionario cuestionario) {
        return cuestionarioRepository.save(cuestionario);
    }

    // R (Read) - Leer todos
    public List<Cuestionario> listarTodos() {
        return cuestionarioRepository.findAll();
    }

    // R (Read) - Leer uno solo por su ID
    public Cuestionario obtenerPorId(Long id) {
        // Si no lo encuentra, devuelve un null en lugar de romper el programa
        return cuestionarioRepository.findById(id).orElse(null);
    }

    // D (Delete) - Eliminar
    public void eliminar(Long id) {
        cuestionarioRepository.deleteById(id);
    }
}