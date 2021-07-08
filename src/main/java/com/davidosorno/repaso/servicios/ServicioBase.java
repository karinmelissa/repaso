package com.davidosorno.repaso.servicios;

import java.util.List;
import java.util.Optional;

import com.davidosorno.repaso.repositorios.RepositorioBase;

import org.springframework.stereotype.Service;

@Service
public abstract class ServicioBase<T> {

    private final RepositorioBase<T> repositorio;

    public ServicioBase(RepositorioBase<T> repositorio) {
        this.repositorio = repositorio;
    }

    public T createOrUpdate(T value){
        return repositorio.save(value);
    }

    public List<T> findAll(){
        return repositorio.findAll();
    }

    public T findById(Long id){
        Optional<T> optional = repositorio.findById(id);
        return optional.isPresent() ? optional.get() : null;
        // if(optional.isPresent()){
        //     return optional.get();
        // } else {
        //     return null;
        // }
    }

    public void deleteById(Long id){
        repositorio.deleteById(id);
    }
    
}
