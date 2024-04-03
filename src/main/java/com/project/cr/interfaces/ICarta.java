package com.project.cr.interfaces;

import com.project.cr.model.Carta;
import java.util.List;


public interface ICarta {

    List<Carta> findAll();
    List<Carta> search(String palabra);
}
