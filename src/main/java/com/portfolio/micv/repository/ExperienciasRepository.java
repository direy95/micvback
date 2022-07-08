package com.portfolio.micv.repository;

import com.portfolio.micv.model.Experiencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciasRepository extends JpaRepository<Experiencias, Long> {
    
}
