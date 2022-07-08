package com.portfolio.micv.controller;

import com.portfolio.micv.model.Estudios;
import com.portfolio.micv.service.EstudiosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EstudioController {
    @Autowired EstudiosService estudioService;
    
    @GetMapping("estudios/traer")
    public List<Estudios> getEstudios(){
        return estudioService.getEstudio();
    }
    
    @PostMapping("estudios/crear")
    public String createEstudio(@RequestBody Estudios estudio){
        estudioService.saveEstudio(estudio);
        return "El estudio fue creado correctamente";
    }
}
