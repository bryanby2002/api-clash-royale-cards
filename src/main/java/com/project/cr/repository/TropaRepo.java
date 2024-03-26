package com.project.cr.repository;

import com.project.cr.model.CTropa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TropaRepo extends JpaRepository<CTropa, Long> {

}
