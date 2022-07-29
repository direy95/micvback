package com.portfolio.micv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String nombre;
    @NotBlank
    private String desc;
    @NotBlank
    private int anoI;
    private int anoF;
    private String expImg;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombre, String desc, int anoI, int anoF, String expImg) {
        this.nombre = nombre;
        this.desc = desc;
        this.anoI = anoI;
        this.anoF = anoF;
        this.expImg = expImg;
    }
}
