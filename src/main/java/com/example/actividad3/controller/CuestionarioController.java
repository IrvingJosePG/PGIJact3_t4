package com.example.actividad3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad3.model.Cuestionario;
import com.example.actividad3.model.Materia;
import com.example.actividad3.service.CuestionarioService;

@RestController
@RequestMapping("/api/cuestionarios")
public class CuestionarioController {

    @Autowired
    private CuestionarioService cuestionarioService;
    
    @Autowired
    private com.example.actividad3.repository.MateriaRepository materiaRepository;

    // 1. C (Create) - Crear un nuevo cuestionario
    @PostMapping
    public Cuestionario crearCuestionario(@RequestBody Cuestionario cuestionario) {
        // Busca la materia completa en la base de datos usando el ID proporcionado
        if (cuestionario.getMateria() != null && cuestionario.getMateria().getId() != null) {
            Materia materiaCompleta = materiaRepository.findById(cuestionario.getMateria().getId()).orElse(null);
            cuestionario.setMateria(materiaCompleta);
        }
        return cuestionarioService.guardar(cuestionario);
    }

    // 2. R (Read) - Listar todos los cuestionarios
    @GetMapping
    public List<Cuestionario> listarCuestionarios() {
        return cuestionarioService.listarTodos();
    }

    // 2.1 R (Read) - Buscar un solo cuestionario por ID
    @GetMapping("/{id}")
    public Cuestionario obtenerCuestionario(@PathVariable Long id) {
        return cuestionarioService.obtenerPorId(id);
    }

    // 3. U (Update) - Actualizar un cuestionario existente
    @PutMapping("/{id}")
    public Cuestionario actualizarCuestionario(@PathVariable Long id, @RequestBody Cuestionario cuestionarioActualizado) {
        Cuestionario cuestionarioExistente = cuestionarioService.obtenerPorId(id);
        if (cuestionarioExistente != null) {
            // Actualizamos los datos
            cuestionarioExistente.setTitulo(cuestionarioActualizado.getTitulo());
            cuestionarioExistente.setMateria(cuestionarioActualizado.getMateria());
            // Guardamos el actualizado (save sirve para actualizar si ya tiene ID)
            return cuestionarioService.guardar(cuestionarioExistente);
        }
        return null; // En un escenario real aquí devolveríamos un error 404
    }

    // 4. D (Delete) - Eliminar un cuestionario
    @DeleteMapping("/{id}")
    public String eliminarCuestionario(@PathVariable Long id) {
        cuestionarioService.eliminar(id);
        return "Cuestionario con ID " + id + " eliminado con éxito.";
    }
}