package com.portfolio.micv.service;

import com.portfolio.micv.model.Persona;
import com.portfolio.micv.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired PersonaRepository personaRepository;
    @Override
    public List<Persona> getPersonas() {
        List<Persona> persona = personaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long Id) {
        personaRepository.deleteById(Id);
    }

    @Override
    public Persona findPersona(Long Id) {
        Persona persona = personaRepository.findById(Id).orElse(null);
        return persona;
    }
    
}
