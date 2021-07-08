package com.davidosorno.repaso.repositorios;

import com.davidosorno.repaso.modelos.Ninja;

import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends RepositorioBase<Ninja> {
    
    boolean existsByEmail(String email);
    
}
