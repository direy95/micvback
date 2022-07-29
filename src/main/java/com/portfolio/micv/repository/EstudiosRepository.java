package com.portfolio.micv.repository;

import com.portfolio.micv.model.Estudios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Integer> {
    public Optional<Estudios> findByNombre (String nombre);
    
    public boolean existsByNombre(String nombre);
}
