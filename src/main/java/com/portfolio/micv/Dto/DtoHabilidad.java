package com.portfolio.micv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHabilidad {
    @NotBlank
    private String skill;
    @NotBlank
    private int porcentaje;
    private String img_skill;

    public DtoHabilidad() {
    }

    public DtoHabilidad(String skill, int porcentaje, String img_skill) {
        this.skill = skill;
        this.porcentaje = porcentaje;
        this.img_skill = img_skill;
    }
}
