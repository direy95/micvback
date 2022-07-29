package com.portfolio.micv.repository;

import com.portfolio.micv.model.Experiencias;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciasRepository extends JpaRepository<Experiencias, Integer> {
    public Optional<Experiencias> findByNombre (String nombre);
    
    public boolean existsByNombre(String nombre);
}
