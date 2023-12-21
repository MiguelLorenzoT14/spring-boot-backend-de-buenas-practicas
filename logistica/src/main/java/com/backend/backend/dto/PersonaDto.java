package com.backend.backend.dto;

import lombok.Data;

@Data
public class PersonaDto {
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String fullName;

    public String getFullName() {
        return nombre+" "+apellido_paterno+" "+apellido_materno;
    }

}
