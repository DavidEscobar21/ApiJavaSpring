package com.example.Crud.Controller;

import com.example.Crud.model.Usuario;
import com.example.Crud.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiCrud {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/saludar")
    public String saludar() {
        return "Hola Mundo";
    }

    @GetMapping("/all")
    public ArrayList<Usuario> getAllUsers(){
        return usuarioService.getAllUsers();
    }

    @GetMapping("/find/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") Integer id){
        return usuarioService.getUserById(id);
    }

    @PostMapping("/save")
    public Usuario saveUser (@RequestBody Usuario u){
        return usuarioService.saveUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        if (usuarioService.deleteUserById(id)){
            return "Registro ha sido eliminado con éxito";
        }else {
            return "Error al eliminar registro";
        }
    }

}
