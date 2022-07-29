package com.portfolio.micv.service;

import com.portfolio.micv.model.Estudios;
import com.portfolio.micv.repository.EstudiosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService{
    @Autowired EstudiosRepository estRepository;
    
    public List<Estudios> list(){
        return estRepository.findAll();
    }
    
    public Optional<Estudios> getOne(int id){
        return estRepository.findById(id);
    }
    
    public Optional<Estudios> getByNombreE(String nombre){
        return estRepository.findByNombre(nombre);
    }
    
    public void save (Estudios est){
        estRepository.save(est);
    }
    
    public void delete(int id){
        estRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return estRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return estRepository.existsByNombre(nombre);
    }
    
    
}
