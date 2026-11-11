package com.example.actividad3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.actividad3.model.Materia;
import com.example.actividad3.repository.MateriaRepository;

@Service // Le dice a Spring que esta clase es un Servicio
public class MateriaService {

    @Autowired // Inyecta el repositorio automáticamente
    private MateriaRepository materiaRepository;

    public List<Materia> listarTodas() {
        return materiaRepository.findAll();
    }

    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia);
    }
}