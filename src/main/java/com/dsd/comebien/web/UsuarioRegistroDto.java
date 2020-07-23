package com.dsd.comebien.web;

/**
 * @author Claudio Nicolas
 */
public class UsuarioRegistroDto {
    
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private float peso;
    private float altura;
    private String password;

    public UsuarioRegistroDto() {
        
    }

    public UsuarioRegistroDto(String rut, String nombre, String apellido, String email, float peso, float altura, String password) {
        super();
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.peso = peso;
        this.altura = altura;
        this.password = password;
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
    
    
}
