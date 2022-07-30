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
    private String descExp;
    private int anoI;
    private int anoF;
    private String expImg;
    
    public Experiencias() {
    }

    public Experiencias(String nombre, String descExp, int anoI, int anoF, String expImg) {
        this.nombre = nombre;
        this.descExp = descExp;
        this.anoI = anoI;
        this.anoF = anoF;
        this.expImg = expImg;
    }
}
