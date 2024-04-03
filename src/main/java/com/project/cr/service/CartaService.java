package com.project.cr.service;

import com.project.cr.interfaces.ICarta;
import com.project.cr.model.Carta;
import com.project.cr.repository.CartaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService implements ICarta {

    private final CartaRepo cartaRepo;

    public CartaService(CartaRepo cartaRepo){
        this.cartaRepo = cartaRepo;
    }

    @Override
    public List<Carta> findAll() {
        return cartaRepo.findAll();
    }

    @Override
    public List<Carta> search(String palabra) {
        return cartaRepo.search(palabra);
    }
}
