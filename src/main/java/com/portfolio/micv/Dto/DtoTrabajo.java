package com.portfolio.micv.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoTrabajo {
    @NotBlank
    private String nombreT;
    @NotBlank
    private String descTrabajo;

    public DtoTrabajo() {
    }

    public DtoTrabajo(String nombreT, String descTrabajo) {
        this.nombreT = nombreT;
        this.descTrabajo = descTrabajo;
    }
    
    
}
