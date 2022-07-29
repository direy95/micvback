package com.portfolio.micv.repository;

import com.portfolio.micv.model.Trabajos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajosRepository extends JpaRepository<Trabajos, Integer>{
    public Optional<Trabajos> findByNombreT (String nombreT);
    
    public boolean existsByNombreT(String nombreT);
}
