package com.portfolio.micv.service;

import com.portfolio.micv.model.Experiencias;
import com.portfolio.micv.repository.ExperienciasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciasService implements IExperienciasService {
    @Autowired ExperienciasRepository experienciasRepository;
    
    @Override
    public List<Experiencias> getExperiencias() {
        List <Experiencias> experiencias = experienciasRepository.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(Experiencias experiencia) {
        experienciasRepository.save(experiencia);
    }

    @Override
    public void delExperiencia(Long id) {
        experienciasRepository.deleteById(id);
    }

    @Override
    public Experiencias findExperiencia(Long id) {
        Experiencias experiencia = experienciasRepository.findById(id).orElse(null);
        return experiencia;
    }
    
}
