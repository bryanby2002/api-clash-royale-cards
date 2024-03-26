package com.project.cr.interfaces;

import com.project.cr.model.Carta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICarta {

    List<Carta> findAll();
}
