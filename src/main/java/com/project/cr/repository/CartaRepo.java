package com.project.cr.repository;

import com.project.cr.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartaRepo extends JpaRepository<Carta, Long> {

    @Query(
            "select c from Carta c where c.nombre like :palabra% " +
                    "or c.calidad like :palabra% " +
                    "or c.tipo like :palabra% "
    )
    List<Carta>search(@Param(value = "palabra") String palabra);

}
