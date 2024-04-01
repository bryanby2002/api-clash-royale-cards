package com.project.cr.repository;

import com.project.cr.model.Tropa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TropaRepo extends JpaRepository<Tropa, Long> {

}
