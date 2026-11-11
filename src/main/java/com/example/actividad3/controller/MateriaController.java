package com.example.actividad3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad3.model.Materia;
import com.example.actividad3.service.MateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    // Crear una nueva materia
    @PostMapping
    public Materia crearMateria(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

    // Listar todas las materias
    @GetMapping
    public List<Materia> listarMaterias() {
        return materiaService.listarTodas();
    }
}