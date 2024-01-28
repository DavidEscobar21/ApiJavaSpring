package com.example.Crud.service;

import com.example.Crud.model.Usuario;
import com.example.Crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ArrayList<Usuario> getAllUsers() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUserById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario saveUser(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        try {
            Optional<Usuario> u = getUserById(id);
            usuarioRepository.delete(u.get());
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
