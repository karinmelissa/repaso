package com.davidosorno.repaso.servicios;

import com.davidosorno.repaso.modelos.Dojo;
import com.davidosorno.repaso.repositorios.DojoRepository;

import org.springframework.stereotype.Service;

@Service
public class DojoService extends ServicioBase<Dojo> {
 
    // private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        super(dojoRepository);
        // this.dojoRepository = dojoRepository;
    }
    
    public void update(Long id, Dojo dojo){
        Dojo dojoActual = findById(id);
        if(dojoActual != null){
            dojoActual.setNombre(dojo.getNombre());
            createOrUpdate(dojoActual);
        }
    }
}
