package com.project.cr.controller;

import com.project.cr.dto.TropaRequest;
import com.project.cr.repository.TropaRepo;
import com.project.cr.service.TropaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tropa")
@Slf4j
public class TropaController {

    private final TropaService tropaService;
    private final TropaRepo tropaRepo;

    public TropaController(TropaService tropaService,TropaRepo tropaRepo)
    {
        this.tropaService= tropaService;
        this.tropaRepo = tropaRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid TropaRequest tropa) {
        tropaService.save(tropa);
        log.info("Registrando carta tipo tropa");
        return  new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TropaRequest tropa){
        if(tropaRepo.existsById(id)){
            tropa.setId(id);
            tropaService.save(tropa);
            log.info("Actualizando carta tropa");
            return new ResponseEntity<>("Actualizado correctamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not found Id ", HttpStatus.NOT_FOUND);
    }
}
