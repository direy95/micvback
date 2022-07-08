package com.portfolio.micv.service;

import com.portfolio.micv.model.Experiencias;
import java.util.List;

public interface IExperienciasService {
    //Traer una lista de experiencias
    public List<Experiencias> getExperiencias();
    
    //Guardar un objeto del tipo persona
    public void saveExperiencia(Experiencias experiencia);
    
    //Eliminar un usuario por id
    public void delExperiencia(Long id);
    
    //Buscar persona por Id
    public Experiencias findExperiencia(Long id);
}
