package com.example.actividad3.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materias") // MySQL reconoce cómo llamar a la tabla
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Relación 1 a N. Una materia tiene una lista de muchos cuestionarios.
    // "mappedBy" indica que la entidad Cuestionario es dueña de la llave foránea.
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cuestionario> cuestionarios;

    // Constructor vacío
    public Materia() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Cuestionario> getCuestionarios() { return cuestionarios; }
    public void setCuestionarios(List<Cuestionario> cuestionarios) { this.cuestionarios = cuestionarios; }
}