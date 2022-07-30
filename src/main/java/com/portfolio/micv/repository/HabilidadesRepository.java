package com.portfolio.micv.repository;

import com.portfolio.micv.model.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer>{
    public Optional<Habilidades> findBySkill (String skill);
    
    public boolean existsBySkill(String skill);
}
