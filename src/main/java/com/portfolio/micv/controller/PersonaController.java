package com.portfolio.micv.controller;

import com.portfolio.micv.Dto.DtoPersona;
import com.portfolio.micv.model.Persona;
import com.portfolio.micv.security.controller.Mensaje;
import com.portfolio.micv.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return personaService.findPersona((int) 1);
    }
    
    //Solo va a estar autorizado el admin en este caso para hacer post (en este caso)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("personas/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoP) {

        Persona pers = personaService.getOne(id).get();
        pers.setNombre(dtoP.getNombre());
        pers.setApellido(dtoP.getApellido());
        pers.setAcerca(dtoP.getAcerca());
        pers.setImg(dtoP.getImg());

        personaService.savePersona(pers);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
