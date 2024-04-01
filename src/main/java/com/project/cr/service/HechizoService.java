package com.project.cr.service;

import com.project.cr.interfaces.IHechizo;
import com.project.cr.model.Hechizo;
import com.project.cr.repository.HechizoRepo;
import org.springframework.stereotype.Service;

@Service
public class HechizoService implements IHechizo {

    private final HechizoRepo cHechizoRepo;

    public HechizoService(HechizoRepo cHechizoRepo){
        this.cHechizoRepo = cHechizoRepo;
    }

    @Override
    public Hechizo create(Hechizo hechizo) {
        return cHechizoRepo.save(hechizo);
    }


}
