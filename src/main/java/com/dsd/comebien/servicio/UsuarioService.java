package com.dsd.comebien.servicio;

import com.dsd.comebien.modelo.Usuario;
import com.dsd.comebien.web.UsuarioRegistroDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Claudio Nicolas
 */
public interface UsuarioService extends UserDetailsService {
    Usuario save(UsuarioRegistroDto registroDto);
}
