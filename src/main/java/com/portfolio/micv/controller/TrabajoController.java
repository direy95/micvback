package com.portfolio.micv.controller;

import com.portfolio.micv.Dto.DtoTrabajo;
import com.portfolio.micv.model.Trabajos;
import com.portfolio.micv.security.controller.Mensaje;
import com.portfolio.micv.service.TrabajosService;
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
@RequestMapping("/trabajo")
@CrossOrigin
public class TrabajoController {

    @Autowired
    TrabajosService trabajosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Trabajos>> list() {
        List<Trabajos> list = trabajosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajos> getById(@PathVariable("id") int id) {
        if (!trabajosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe id"), HttpStatus.NOT_FOUND);
        }
        Trabajos trabajo = trabajosService.getOne(id).get();

        return new ResponseEntity(trabajo, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoTrabajo dtoT) {
        if (StringUtils.isBlank(dtoT.getNombreT())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (trabajosService.existsByNombreT(dtoT.getNombreT())) {
            return new ResponseEntity(new Mensaje("Ese trabajo ya existe"), HttpStatus.BAD_REQUEST);
        }

        Trabajos trabajo = new Trabajos(dtoT.getNombreT(), dtoT.getDescTrabajo());
        trabajosService.save(trabajo);

        return new ResponseEntity(new Mensaje("El trabajo fue agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoTrabajo dtoT) {
        //Valido si existe el id
        if (!trabajosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de trabajos
        if (trabajosService.existsByNombreT(dtoT.getNombreT()) && trabajosService.getByNombreT(dtoT.getNombreT()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Verifica si está vacío
        if (StringUtils.isBlank(dtoT.getNombreT())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Trabajos trabajo = trabajosService.getOne(id).get();
        trabajo.setNombreT(dtoT.getNombreT());
        trabajo.setDescTrabajo(dtoT.getDescTrabajo());

        trabajosService.save(trabajo);
        return new ResponseEntity(new Mensaje("Trabajo actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validamos si existe el id
        if (!trabajosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        trabajosService.delete(id);
        return new ResponseEntity(new Mensaje("Trabajo eliminado"), HttpStatus.OK);
    }
}
