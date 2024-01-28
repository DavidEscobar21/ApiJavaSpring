package com.example.Crud.service;

import com.example.Crud.model.Usuario;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioService {

    ArrayList<Usuario> getAllUsers();
    Optional<Usuario> getUserById(Integer id);
    Usuario saveUser(Usuario u);
    boolean deleteUserById(Integer id);

}
