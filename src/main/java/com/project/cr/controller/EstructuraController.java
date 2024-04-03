package com.project.cr.controller;

import com.project.cr.dto.EstructuraRequest;
import com.project.cr.repository.EstructuraRepo;
import com.project.cr.service.EstructuraService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estructura")
@Slf4j
public class EstructuraController {

    private final EstructuraRepo estructuraRepo;
    private final EstructuraService cEstructuraService;

    public EstructuraController(EstructuraService cEstructuraService, EstructuraRepo estructuraRepo)
    {
        this.cEstructuraService = cEstructuraService;
        this.estructuraRepo = estructuraRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid EstructuraRequest estructura) {
        this.cEstructuraService.save(estructura);
        log.info("Registrando carta estructura");
        return new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EstructuraRequest estructura){
        if(estructuraRepo.existsById(id)){
            estructura.setId(id);
            cEstructuraService.save(estructura);
            return new ResponseEntity<>("Actualizado correctamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not found Id", HttpStatus.NOT_FOUND);
    }
}