package com.davidosorno.repaso.servicios;

import com.davidosorno.repaso.modelos.Ninja;
import com.davidosorno.repaso.repositorios.NinjaRepository;

import org.springframework.stereotype.Service;

@Service
public class NinjaService extends ServicioBase<Ninja> {
    
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        super(ninjaRepository);
        this.ninjaRepository = ninjaRepository;
    }

    public void update(Long id, Ninja ninja){
        Ninja ninjaActual = findById(id);
        if(ninjaActual != null){
            ninjaActual.setNombre(ninja.getNombre());
            ninjaActual.setApellido(ninja.getApellido());
            ninjaActual.setEdad(ninja.getEdad());
            createOrUpdate(ninja);
        }
    }

    public boolean emailExist(String email){
        return ninjaRepository.existsByEmail(email);
    }
}
