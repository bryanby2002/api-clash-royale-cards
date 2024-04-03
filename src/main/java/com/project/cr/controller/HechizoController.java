package com.project.cr.controller;

import com.project.cr.dto.HechizoRequest;
import com.project.cr.repository.HechizoRepo;
import com.project.cr.service.HechizoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> create(@RequestBody HechizoRequest hechizo) {
        hechizoService.save(hechizo);
        log.info("Registrando carta hechizo");
        return new ResponseEntity<>("Registrado correctamente", HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HechizoRequest hechizo) {
        if(hechizoRepo.existsById(id)){
            hechizo.setId(id);
            hechizoService.save(hechizo);
            log.info("Registrando carta hechizo");
            return new ResponseEntity<>("Actualizando correctamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not found id", HttpStatus.NOT_FOUND);
    }
}
