package com.project.cr.controller;

import com.project.cr.model.CHechizo;
import com.project.cr.repository.HechizoRepo;
import com.project.cr.service.HechizoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hechizo")
@Slf4j
public class HechizoController {

    private final HechizoService hechizoService;
    private final HechizoRepo hechizoRepo;

    public HechizoController(HechizoService hechizoService, HechizoRepo hechizoRepo)
    {
        this.hechizoService = hechizoService;
        this.hechizoRepo = hechizoRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CHechizo hechizo) {
        hechizoService.create(hechizo);
        log.info("Registrando carta hechizo");
        return new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CHechizo hechizo) {
        Optional<CHechizo> hechizoOptional = hechizoRepo.findById(id);
        return hechizoOptional.isPresent() ?
                new ResponseEntity<>(this.hechizoService.create(hechizo), HttpStatus.CREATED) :
                new ResponseEntity<>("Not found ID", HttpStatus.NOT_FOUND);
    }
}
