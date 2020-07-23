package com.dsd.comebien.modelo;

import java.util.Collection;
import javax.persistence.*;

/**
 * @author Claudio Nicolas
 */
@Entity
@Table(name="usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    private String email;
    private float peso;
    private float altura;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
                name = "usuarios_roles",
                joinColumns = @JoinColumn(
                    name = "usuario_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(
                                        name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    public Usuario() {
        
    }

    public Usuario(String rut, String nombre, String apellido, String email, float peso, float altura, String password, Collection<Rol> roles) {
        super();
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.peso = peso;
        this.altura = altura;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
    
    
    
}
