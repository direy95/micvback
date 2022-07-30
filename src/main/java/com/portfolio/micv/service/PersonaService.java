package com.portfolio.micv.service;

import com.portfolio.micv.model.Persona;
import com.portfolio.micv.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService{
    @Autowired PersonaRepository personaRepository;
    
    public List<Persona> getPersonas() {
        List<Persona> persona = personaRepository.findAll();
        return persona;
    }


    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void deletePersona(int Id) {
        personaRepository.deleteById(Id);
    }

    public Optional<Persona> getOne(int id){
        return personaRepository.findById(id);
    }
    
    public Persona findPersona(int Id) {
        Persona persona = personaRepository.findById(Id).orElse(null);
        return persona;
    }
    
}
