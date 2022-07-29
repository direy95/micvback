package com.portfolio.micv.service;

import com.portfolio.micv.model.Trabajos;
import com.portfolio.micv.repository.TrabajosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrabajosService {
    @Autowired TrabajosRepository trabajosRepository;
    
    public List<Trabajos> list(){
        return trabajosRepository.findAll();
    }
    
    public Optional<Trabajos> getOne(int id){
        return trabajosRepository.findById(id);
    }
    
    public Optional<Trabajos> getByNombreT(String nombreT){
        return trabajosRepository.findByNombreT(nombreT);
    }
    
    public void save (Trabajos trabajo){
        trabajosRepository.save(trabajo);
    }
    
    public void delete(int id){
        trabajosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return trabajosRepository.existsById(id);
    }
    
    public boolean existsByNombreT(String nombreT){
        return trabajosRepository.existsByNombreT(nombreT);
    }
}
