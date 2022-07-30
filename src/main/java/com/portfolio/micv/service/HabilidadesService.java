package com.portfolio.micv.service;

import com.portfolio.micv.model.Habilidades;
import com.portfolio.micv.repository.HabilidadesRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadesService{
    @Autowired HabilidadesRepository habRepo;
    
    public List<Habilidades> list(){
        return habRepo.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return habRepo.findById(id);
    }
    
    public Optional<Habilidades> getByNombre(String skill){
        return habRepo.findBySkill(skill);
    }
    
    public void save (Habilidades hab){
        habRepo.save(hab);
    }
    
    public void delete(int id){
        habRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habRepo.existsById(id);
    }
    
    public boolean existsBySkill(String skill){
        return habRepo.existsBySkill(skill);
    }
    
}
