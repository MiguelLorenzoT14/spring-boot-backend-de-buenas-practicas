package com.backend.backend.mapper;

import com.backend.backend.dto.PersonaDto;
import com.backend.backend.entity.Persona;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonaMapper {

    public PersonaDto toDTO(Persona persona) {
        PersonaDto personaDTO = new PersonaDto();
        BeanUtils.copyProperties(persona,personaDTO);
        return personaDTO;
    }

    public List<PersonaDto> toDTOList(List<Persona> personaList) {
        List<PersonaDto> PersonaDto = new ArrayList<>();

        for(Persona persona: personaList){
            PersonaDto.add(toDTO(persona));
        }
        return PersonaDto;
    }
}
