package com.project.cr.controller;

import com.project.cr.model.CEstructura;
import com.project.cr.repository.EstructuraRepo;
import com.project.cr.service.EstructuraService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<?> create(@RequestBody @Valid CEstructura estructura) {
        this.cEstructuraService.create(estructura);
        log.info("Registrando carta estructura");
        return new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CEstructura estructura){
        Optional<CEstructura>estructuraCard = estructuraRepo.findById(id);
        return estructuraCard.isPresent() ?
                new ResponseEntity<>(this.cEstructuraService.create(estructura), HttpStatus.CREATED) :
                new ResponseEntity<>("Not found ID", HttpStatus.NOT_FOUND);

    }


}