package com.dsd.comebien.servicio;

import com.dsd.comebien.dao.UsuarioDao;
import com.dsd.comebien.modelo.Rol;
import com.dsd.comebien.modelo.Usuario;
import com.dsd.comebien.web.UsuarioRegistroDto;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Claudio Nicolas
 */
@Service
public class UserServiceImpl implements UsuarioService {
    
    private UsuarioDao usuarioDao;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserServiceImpl (UsuarioDao usuarioDao) {
        super();
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario save(UsuarioRegistroDto registroDto) {
        Usuario usuario = new Usuario(registroDto.getNombre(),registroDto.getRut(),
                              registroDto.getApellido(), registroDto.getEmail(),
                              registroDto.getPeso(), registroDto.getAltura(),
                              passwordEncoder.encode(registroDto.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
        
        return usuarioDao.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioDao.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o Contraseña inválida.");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), mapRolesToAuthorities(usuario.getRoles()));
    }
    
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
    }
    
}
