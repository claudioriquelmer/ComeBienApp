package com.dsd.comebien.modelo;

import javax.persistence.*;

/**
 * @author Claudio Nicolas
 */
@Entity
@Table(name="rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreRol;

    public Rol() {
        
    }

    public Rol(String nombreRol) {
        super();
        this.nombreRol = nombreRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
}
