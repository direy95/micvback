package com.portfolio.micv.controller;

import com.portfolio.micv.model.Persona;
import com.portfolio.micv.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired PersonaService personaService;
    
    @GetMapping("personas/traer")
    public Persona findPersona(){
        //long hace ref a tipo de dato que maneja el id
        return personaService.findPersona((long) 1);
    }
    
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //Url puerto/personas/editar/id/parametro(nombre and apellido and img)
    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                              @RequestParam("nombre") String nuevoNombre,
                              @RequestParam("apellido") String nuevoApellido,
                              @RequestParam("img") String nuevoImg){
        Persona persona = personaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        personaService.savePersona(persona);
        return persona;
    }
}
