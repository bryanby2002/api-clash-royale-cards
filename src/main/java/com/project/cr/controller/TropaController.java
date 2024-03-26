package com.project.cr.controller;

import com.project.cr.model.CTropa;
import com.project.cr.repository.TropaRepo;
import com.project.cr.service.TropaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<?> create(@RequestBody @Valid CTropa tropa) {
        tropaService.create(tropa);
        log.info("Registrando carta tipo tropa");
        return  new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CTropa tropa){
        Optional<CTropa> tropaOptional = tropaRepo.findById(id);
        return tropaOptional.isPresent() ?
                new ResponseEntity<>(this.tropaService.create(tropa), HttpStatus.CREATED) :
                new ResponseEntity<>("Not found ID ", HttpStatus.NOT_FOUND);
    }
}
