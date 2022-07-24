package com.portfolio.micv.security.service;

import com.portfolio.micv.security.entity.Rol;
import com.portfolio.micv.security.enums.RolNombre;
import com.portfolio.micv.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional //Trata de mantener lo mismo que está acá en la base de datos. Lo mismo va a estar ahí si falla
public class RolService {
    @Autowired IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
