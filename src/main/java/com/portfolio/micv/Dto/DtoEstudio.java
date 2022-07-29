package com.portfolio.micv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEstudio {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descEst;
    @NotBlank
    private int anoI;
    private int anoF;
    private String imgEdu;

    public DtoEstudio() {
    }

    public DtoEstudio(String nombre, String descEst, int anoI, int anoF, String imgEdu) {
        this.nombre = nombre;
        this.descEst = descEst;
        this.anoI = anoI;
        this.anoF = anoF;
        this.imgEdu = imgEdu;
    }
}
