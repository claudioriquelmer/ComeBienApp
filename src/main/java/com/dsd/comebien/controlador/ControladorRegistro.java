package com.dsd.comebien.controlador;

import com.dsd.comebien.servicio.UsuarioService;
import com.dsd.comebien.web.UsuarioRegistroDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Claudio Nicolas
 */
@Controller
@RequestMapping("/registro")
public class ControladorRegistro {
    
    private UsuarioService usuarioService;

    public ControladorRegistro(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }
    
    @ModelAttribute("usuario")
    public UsuarioRegistroDto usuarioRegistroDto() {
        return new UsuarioRegistroDto();
    }
    
    @GetMapping
    public String mostrarRegistroForm() {
        return "registro";
    }
    
    @PostMapping
    public String registroCuenta(@ModelAttribute("usuario") UsuarioRegistroDto registroDto) {
        usuarioService.save(registroDto);
        return "redirect:/registro?success";
    }
    
}
