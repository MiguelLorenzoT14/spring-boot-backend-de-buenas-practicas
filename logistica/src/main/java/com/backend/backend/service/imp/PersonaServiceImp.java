package com.backend.backend.service.imp;

import com.backend.backend.dto.PersonaDto;
import com.backend.backend.entity.Persona;
import com.backend.backend.mapper.PersonaMapper;
import com.backend.backend.repository.PersonaRepository;
import com.backend.backend.service.PersonaService;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {


    protected PersonaRepository personaRepository;
    protected PersonaMapper personaMapper;


    public PersonaServiceImp(PersonaRepository personaRepository, PersonaMapper personaMapper) {
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    @Override
    public PersonaDto agregarPersona(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        PersonaDto  personaDTO = personaMapper.toDTO(persona1);
        return personaDTO;
    }
    @Override
    public PersonaDto obtenerPersonaPorId(int id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            PersonaDto personaDTO = personaMapper.toDTO(persona);
            return personaDTO;
        }
        return null;
    }

    @Override
    public List<PersonaDto> obtenerTodasLasPersonas() {
        List<Persona> personaList = personaRepository.findAll();
        List<PersonaDto> PersonaDtoList = personaMapper.toDTOList(personaList);
        return PersonaDtoList;
    }

    @Override
    public boolean actualizarPersona(int id, Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona personaActualizada = personaOptional.get();
            BeanUtils.copyProperties(persona,personaActualizada);
            personaRepository.save(personaActualizada);
            return true;
        }
        return false;
    }

    @Override
    public void eliminarPersona(int id) {
        personaRepository.deleteById(id);
    }

    //como recomendacion en esta parte del  Scheduled hacerlo en una carpeta aparte (ejemplo en este caso "Scheduled")
    //para las buenas practicas
    @Scheduled(fixedRateString = "${tiempo_milisegundos}")
    public void borrarPersonasCada3Segundos() {
        List<Persona> personas = personaRepository.findAll();
        if (!personas.isEmpty()) {
            personaRepository.deleteById(personas.get(0).getId());
        }
    }


}
