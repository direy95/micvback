package com.portfolio.micv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencias {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descE;
    private int anoI;
    private int anoF;
    private String expImg;
    
    public Experiencias() {
    }

    public Experiencias(String nombre, String descE, int anoI, int anoF, String expImg) {
        this.nombre = nombre;
        this.descE = descE;
        this.anoI = anoI;
        this.anoF = anoF;
        this.expImg = expImg;
    }
}
