package com.project.cr.repository;

import com.project.cr.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HechizoRepo extends JpaRepository<Hechizo, Long> {

}
