package com.portfolio.micv.service;

import com.portfolio.micv.model.Estudios;
import com.portfolio.micv.repository.EstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosService implements IEstudiosService{
    @Autowired EstudiosRepository estudiosRepository;
            
    @Override
    public List<Estudios> getEstudio() {
        List<Estudios> estudios = estudiosRepository.findAll();
        return estudios;
    }

    @Override
    public void saveEstudio(Estudios estudio) {
        estudiosRepository.save(estudio);
    }

    @Override
    public void deleteEstudio(Long id) {
        estudiosRepository.deleteById(id);
    }

    @Override
    public Estudios findEstudio(Long id) {
        Estudios estudio = estudiosRepository.findById(id).orElse(null);
        return estudio;
    }
    
}
