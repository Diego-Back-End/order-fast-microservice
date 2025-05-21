package com.example.Usuario.repository;

//importaciones para trabajar con repositorios en spring y jpa
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Usuario.model.Usuario;

/**
 * Esta interfaz se encarga de la comunicación con la base de datos para la entidad Usuario.
 * Gracias a JpaRepository, ya trae muchas funciones listas como guardar, buscar, eliminar, etc.
 */
@Repository // esta clase es un repositorio (una capa de acceso a datos)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}