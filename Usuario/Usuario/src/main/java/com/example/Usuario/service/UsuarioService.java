package com.example.Usuario.service;

//en jarkarta se manejara la base de datos
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuario.model.Usuario;
import com.example.Usuario.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired//se utilizara automaticamente el repositorio para utilizarlo en esta clase
    private UsuarioRepository usuarioRepository;

    //traera los usuarios existentes de la base de datos
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    //traera los usuarios que existen en la base de datos 
    //los podremos llamar por su id
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }


    //crea un nuevo usuario y sera guardado automaticamente en la base de datos
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    //actualiza un usuario existente (id) actualiza (nombre,email) 
    //si no retorna nulo
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        // return usuarioRepository.save(usuarioActualizado);
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setEmail(usuarioActualizado.getEmail());
            return usuarioRepository.save(usuario);
        }).orElse(null);
    }


    //se elimina un usuario por su id
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    //guardara todo de una sola vez
    public List<Usuario> guardarTodos(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }
}