package com.backend.backend.service;

import com.backend.backend.dto.PersonaDto;
import com.backend.backend.entity.Persona;

import java.util.List;

public interface PersonaService {
    PersonaDto agregarPersona(Persona persona);
    PersonaDto obtenerPersonaPorId(int id);
    List<PersonaDto> obtenerTodasLasPersonas();
    boolean actualizarPersona(int id,Persona persona);
    void eliminarPersona(int id);
}
