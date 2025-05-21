package com.example.Restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurante.model.Restaurante;
/**
 * Esta interfaz se encarga de la comunicación con la base de datos para la entidad Usuario.
 * Gracias a JpaRepository, ya trae muchas funciones listas como guardar, buscar, eliminar, etc.
 */
@Repository  // Le dice a Spring que esta clase es un repositorio (una capa de acceso a datos)
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
//jpa traera todos los metodos necesarios como
// save, findbyid, findall, delete, etc

