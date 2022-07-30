package com.portfolio.micv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descExp;
    @NotBlank
    private int anoI;
    private int anoF;
    private String expImg;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombre, String descExp, int anoI, int anoF, String expImg) {
        this.nombre = nombre;
        this.descExp = descExp;
        this.anoI = anoI;
        this.anoF = anoF;
        this.expImg = expImg;
    }
}
