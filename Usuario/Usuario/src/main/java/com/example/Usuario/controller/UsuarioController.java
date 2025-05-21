package com.example.Usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Usuario.model.Usuario;
import com.example.Usuario.service.UsuarioService;

import java.util.List;
import java.util.Optional;

/**
 * Aquí se reciben las peticiones del cliente (como el navegador o Postman)
 * y se envían respuestas con los datos correspondientes.
 */


@RestController // Indica que esta clase responde a solicitudes y devuelve datos en formato JSON
@RequestMapping("/usuarios") // Define la ruta base para todas las peticiones de este controlador
public class UsuarioController {

    @Autowired // Trae el servicio para usar sus funciones en este controlador
    private UsuarioService usuarioService;

    //se obtendran todos los usuarios que repondera a un get hacia "/usuarios"
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }


   //metodo para obtener un usuario por su id
   //responde a un get "/usuarios/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> obtenerPorId(@PathVariable Long id) {
    
        Optional<Usuario> usu = usuarioService.obtenerPorId(id);

        //aqui devuelve 200 ok por si el usuario existe (postman)
        return ResponseEntity.ok(usu);
    }

    //metodo para generar un usuario nuevo
    @PostMapping
    public ResponseEntity<Usuario > crear(@RequestBody Usuario usuario) {

        Usuario us = usuarioService.crearUsuario(usuario);

        //si el id generado es mayor a cero reponde al ok 200 con el usuario creado
        if (us.getId() > 0) {
            return ResponseEntity.ok(us);
        }

        return ResponseEntity.badRequest().body(us);

        //return usuarioService.crearUsuario(usuario);
    }

    //actualiza por un usuario existente por id
    //reposnde por put
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    //elimina usuario por id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    //metodo para guardar varios usuarios en una sola peticion /bulk
    @PostMapping("/bulk")
    public List<Usuario> guardarVarios(@RequestBody List<Usuario> usuarios) {
        return usuarioService.guardarTodos(usuarios);
    }
}






















