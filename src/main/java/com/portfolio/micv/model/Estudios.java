package com.portfolio.micv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descEst;
    private int anoI;
    private int anoF;
    private String imgEdu;

    public Estudios() {
    }

    public Estudios(String nombre, String descEst, int anoI, int anoF, String imgEdu) {
        this.nombre = nombre;
        this.descEst = descEst;
        this.anoI = anoI;
        this.anoF = anoF;
        this.imgEdu = imgEdu;
    }
    
    
}
