package com.project.cr.service;

import com.project.cr.interfaces.ITropa;
import com.project.cr.model.CTropa;
import com.project.cr.repository.TropaRepo;
import org.springframework.stereotype.Service;

@Service
public class TropaService implements ITropa {

    private final TropaRepo cTropaRepo;

    public TropaService(TropaRepo cTropaRepo){
        this.cTropaRepo = cTropaRepo;
    }

    @Override
    public CTropa create(CTropa cTropa) {
        return cTropaRepo.save(cTropa);
    }


}
