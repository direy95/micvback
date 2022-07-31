package com.portfolio.micv.controller;

import com.portfolio.micv.Dto.DtoHabilidad;
import com.portfolio.micv.model.Habilidades;
import com.portfolio.micv.security.controller.Mensaje;
import com.portfolio.micv.service.HabilidadesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/habilidad")
public class HabilidadesController {
    @Autowired
    HabilidadesService habService;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = habService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        if (!habService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Habilidades exp = habService.getOne(id).get();

        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHab) {
        if (StringUtils.isBlank(dtoHab.getSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (habService.existsBySkill(dtoHab.getSkill())) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Habilidades hab = new Habilidades(dtoHab.getSkill(), dtoHab.getPorcentaje(), dtoHab.getImg_skill());
        habService.save(hab);

        return new ResponseEntity(new Mensaje("La Habilidad fue agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtoHab) {
        //Valido si existe el id
        if (!habService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de trabajos
        if (habService.existsBySkill(dtoHab.getSkill()) && habService.getByNombre(dtoHab.getSkill()).get().getId()!= id) {
            return new ResponseEntity(new Mensaje("Esa Habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Verifica si está vacío
        if (StringUtils.isBlank(dtoHab.getSkill())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Habilidades hab = habService.getOne(id).get();
        hab.setSkill(dtoHab.getSkill());
        hab.setPorcentaje(dtoHab.getPorcentaje());

        habService.save(hab);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!habService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        habService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
}
