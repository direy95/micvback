package com.portfolio.micv.security.service;

import com.portfolio.micv.security.entity.Usuario;
import com.portfolio.micv.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class IUserDetails implements UserDetailsService{
    @Autowired UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        //Construimos un usuario con lo que viene de usuario
        return UsuarioPrincipal.build(usuario);
    }
}