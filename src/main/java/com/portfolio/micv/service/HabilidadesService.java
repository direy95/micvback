package com.portfolio.micv.service;

import com.portfolio.micv.model.Habilidades;
import com.portfolio.micv.repository.HabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService{
    @Autowired HabilidadesRepository habilidadesRepository;
    
    @Override
    public List<Habilidades> getHabilidades() {
        List<Habilidades> habilidad = habilidadesRepository.findAll();
        return habilidad;
    }

    @Override
    public void saveHabilidad(Habilidades habilidad) {
        habilidadesRepository.save(habilidad);
    }

    @Override
    public Habilidades findHabilidad(Long id) {
        Habilidades habilidad = habilidadesRepository.findById(id).orElse(null);
        return habilidad;
    }

    @Override
    public void delHabilidad(Long id) {
        habilidadesRepository.deleteById(id);
    }
    
}
