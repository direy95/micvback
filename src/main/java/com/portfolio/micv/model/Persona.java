package com.portfolio.micv.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String img;
    
    //Lazy es para hacer una consulta en especifica. No quiero que traiga todo
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "idEdu")
    //private List<Estudios> estudiosList;
    
    public Persona(){
        
    }

    public Persona(Long id, String nombre, String apellido, String img) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
}
