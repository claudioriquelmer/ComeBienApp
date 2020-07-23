package com.dsd.comebien.dao;

import com.dsd.comebien.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Claudio Nicolas
 */
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByEmail(String email);
}
