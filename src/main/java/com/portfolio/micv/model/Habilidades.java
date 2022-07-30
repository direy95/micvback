package com.portfolio.micv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Habilidades {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skill;
    private int porcentaje;
    private String img_skill;

    public Habilidades() {
    }

    public Habilidades(String skill, int porcentaje, String img_skill) {
        this.skill = skill;
        this.porcentaje = porcentaje;
        this.img_skill = img_skill;
    }
}
