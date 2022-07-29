package com.portfolio.micv.service;

import com.portfolio.micv.model.Experiencias;
import com.portfolio.micv.repository.ExperienciasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciasService {
    @Autowired ExperienciasRepository expRepository;
    
    public List<Experiencias> list(){
        return expRepository.findAll();
    }
    
    public Optional<Experiencias> getOne(int id){
        return expRepository.findById(id);
    }
    
    public Optional<Experiencias> getByNombreE(String nombre){
        return expRepository.findByNombre(nombre);
    }
    
    public void save (Experiencias exp){
        expRepository.save(exp);
    }
    
    public void delete(int id){
        expRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return expRepository.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return expRepository.existsByNombre(nombreE);
    }
    
}
