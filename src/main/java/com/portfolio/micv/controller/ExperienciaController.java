package com.portfolio.micv.controller;

import com.portfolio.micv.model.Experiencias;
import com.portfolio.micv.service.ExperienciasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ExperienciaController {
    @Autowired ExperienciasService experienciasService;
    
    @GetMapping("experiencias/traer")
    public List<Experiencias> getExperiencias(){
        return experienciasService.getExperiencias();
    }
    
    @PostMapping("experiencias/crear")
    public String createExperiencia(@RequestBody Experiencias experiencia){
        experienciasService.saveExperiencia(experiencia);
        return "La experiencia fue creada correctamente";
    }
}
