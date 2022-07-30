package com.portfolio.micv.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    private String nombre;
    private String apellido;
    private String img;
    private String acerca;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img, String acerca) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acerca = acerca;
    }
    
    
}
