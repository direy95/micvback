package com.portfolio.micv.controller;

import com.portfolio.micv.model.Habilidades;
import com.portfolio.micv.service.HabilidadesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HabilidadesController {
    @Autowired HabilidadesService habilidadesService;
    
    @GetMapping("habilidades/traer")
    public List<Habilidades> traerHabilidades(){
        return habilidadesService.getHabilidades();
    }
    
    @PostMapping("habilidades/crear")
    public String crearHabilidad(@RequestBody Habilidades habilidad){
        habilidadesService.saveHabilidad(habilidad);
        return "La habilidad fue creada correctamente";
    }
}
