package com.portfolio.micv.service;

import com.portfolio.micv.model.Estudios;
import java.util.List;

public interface IEstudiosService {
    //Traer liesta de estudios
    public List<Estudios> getEstudio();
    
    //Guardar un objeto estudio
    public void saveEstudio(Estudios estudio);
    
    //Eliminar un objeto estudio
    public void deleteEstudio(Long id);
    
    //Encontrar objeto estudio
    public Estudios findEstudio(Long id);
}
