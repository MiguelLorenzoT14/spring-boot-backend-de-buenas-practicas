package com.backend.backend.controller;
import com.backend.backend.dto.PersonaDto;
import com.backend.backend.entity.Persona;
import com.backend.backend.service.PersonaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    protected PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public PersonaDto agregarPersona(@RequestBody Persona persona) {
       return personaService.agregarPersona(persona);
    }

    @GetMapping("/{id}")
    public PersonaDto obtenerPersonaPorId(@PathVariable int id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @GetMapping
    public List<PersonaDto> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @PutMapping("/{id}")
    public void actualizarPersona(@PathVariable int id, @RequestBody Persona persona) {
        boolean actualizacionExitosa = personaService.actualizarPersona(id, persona);
        if (!actualizacionExitosa) {
            System.out.println("No se puede actualizar. La persona con ID " + id + " no existe.");
        }
    }


    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable int id) {
        personaService.eliminarPersona(id);
    }
}
