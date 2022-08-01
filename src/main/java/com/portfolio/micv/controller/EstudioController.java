package com.portfolio.micv.controller;

import com.portfolio.micv.Dto.DtoEstudio;
import com.portfolio.micv.model.Estudios;
import com.portfolio.micv.model.Experiencias;
import com.portfolio.micv.security.controller.Mensaje;
import com.portfolio.micv.service.EstudiosService;
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
@RequestMapping("/estudio")
@CrossOrigin
public class EstudioController {
    @Autowired EstudiosService estService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudios>> list() {
        List<Estudios> list = estService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencias> getById(@PathVariable("id") int id) {
        if (!estService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
        }
        Estudios est = estService.getOne(id).get();

        return new ResponseEntity(est, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoE) {
        if (StringUtils.isBlank(dtoE.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Estudios est = new Estudios(dtoE.getNombre(), dtoE.getDescEst(), dtoE.getAnoI(), dtoE.getAnoF(), dtoE.getImgEdu());
        estService.save(est);

        return new ResponseEntity(new Mensaje("El estudio fue agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoE) {
        //Valido si existe el id
        if (!estService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        //Verifica si está vacío
        if (StringUtils.isBlank(dtoE.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Estudios est = estService.getOne(id).get();
        est.setNombre(dtoE.getNombre());
        est.setDescEst(dtoE.getDescEst());
        est.setAnoI(dtoE.getAnoI());
        est.setAnoF(dtoE.getAnoF());

        estService.save(est);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!estService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        estService.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }
}
