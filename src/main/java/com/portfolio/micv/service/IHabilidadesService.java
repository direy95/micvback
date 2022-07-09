package com.portfolio.micv.service;

import com.portfolio.micv.model.Habilidades;
import java.util.List;


public interface IHabilidadesService {
    public List<Habilidades> getHabilidades();
    public void saveHabilidad(Habilidades habilidad);
    public Habilidades findHabilidad(Long id);
    public void delHabilidad(Long id);
}
