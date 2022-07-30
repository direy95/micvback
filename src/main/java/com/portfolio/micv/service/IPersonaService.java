package com.portfolio.micv.service;

import com.portfolio.micv.model.Persona;
import java.util.List;

public interface IPersonaService {
    //Traer una lista de personas
    public List<Persona> getPersonas();
    
    //Guardar un objeto del tipo persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario por id
    public void deletePersona(int Id);
    
    //Buscar persona por Id
    public Persona findPersona(int Id);
}
