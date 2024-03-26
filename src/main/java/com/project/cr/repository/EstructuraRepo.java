package com.project.cr.repository;

import com.project.cr.model.CEstructura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstructuraRepo extends JpaRepository<CEstructura, Long> {

}
