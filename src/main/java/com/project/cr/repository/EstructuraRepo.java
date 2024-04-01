package com.project.cr.repository;

import com.project.cr.model.Estructura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstructuraRepo extends JpaRepository<Estructura, Long> {

}
