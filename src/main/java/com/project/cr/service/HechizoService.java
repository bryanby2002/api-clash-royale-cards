package com.project.cr.service;

import com.project.cr.interfaces.IHechizo;
import com.project.cr.model.CHechizo;
import com.project.cr.repository.HechizoRepo;
import org.springframework.stereotype.Service;

@Service
public class HechizoService implements IHechizo {

    private final HechizoRepo cHechizoRepo;

    public HechizoService(HechizoRepo cHechizoRepo){
        this.cHechizoRepo = cHechizoRepo;
    }

    @Override
    public CHechizo create(CHechizo cHechizo) {
        return cHechizoRepo.save(cHechizo);
    }


}
