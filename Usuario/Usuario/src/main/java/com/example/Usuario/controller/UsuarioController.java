package com.example.Usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Usuario.model.Usuario;
import com.example.Usuario.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }


    // ResponseEntity
    // Status Code
    // Status code es en español Codigo de respuesta
    // Sirve para saber que paso con la solicitud que mande, para que el cliente que hace la solicitud
    // Sabe realmente que paso, sin necesidad de revisar el JSON, saberse su estructura ETC
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> obtenerPorId(@PathVariable Long id) {
    
        Optional<Usuario> usu = usuarioService.obtenerPorId(id);

        // Validas si el usuario existe
        // Si existe devuelves el usuario con el status 200 por ejemplo
        return ResponseEntity.ok(usu);
    }

    @PostMapping
    public ResponseEntity<Usuario > crear(@RequestBody Usuario usuario) {

        Usuario us = usuarioService.crearUsuario(usuario);

        if (us.getId() > 0) {
            return ResponseEntity.ok(us);
        }

        return ResponseEntity.badRequest().body(us);

        //return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
    @PostMapping("/bulk")
    public List<Usuario> guardarVarios(@RequestBody List<Usuario> usuarios) {
        return usuarioService.guardarTodos(usuarios);
    }
}






















