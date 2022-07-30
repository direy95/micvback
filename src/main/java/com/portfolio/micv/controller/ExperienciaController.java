package com.portfolio.micv.controller;

import com.portfolio.micv.Dto.DtoExperiencia;
import com.portfolio.micv.model.Experiencias;
import com.portfolio.micv.security.controller.Mensaje;
import com.portfolio.micv.service.ExperienciasService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ExperienciasService expService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencias>> list() {
        List<Experiencias> list = expService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencias> getById(@PathVariable("id") int id) {
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Experiencias exp = expService.getOne(id).get();

        return new ResponseEntity(exp, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoE) {
        if (StringUtils.isBlank(dtoE.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (expService.existsByNombreE(dtoE.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencias exp = new Experiencias(dtoE.getNombre(), dtoE.getDescExp(), dtoE.getAnoI(), dtoE.getAnoF(), dtoE.getExpImg());
        expService.save(exp);

        return new ResponseEntity(new Mensaje("La experiencia fue agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoE) {
        //Valido si existe el id
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de trabajos
        if (expService.existsByNombreE(dtoE.getNombre()) && expService.getByNombreE(dtoE.getNombre()).get().getId()!= id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Verifica si está vacío
        if (StringUtils.isBlank(dtoE.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencias exp = expService.getOne(id).get();
        exp.setNombre(dtoE.getNombre());
        exp.setDescExp(dtoE.getDescExp());

        expService.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!expService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        expService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
