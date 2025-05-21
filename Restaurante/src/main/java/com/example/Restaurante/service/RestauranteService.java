package com.example.Restaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.repository.RestauranteRepository;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase contiene la lógica de negocio relacionada con los restaurantes.
 * Se encarga de procesar los datos antes de guardarlos, actualizarlos o devolverlos.
 */
@Service // Le dice a Spring que esta clase es un "servicio", o sea, donde se maneja la lógica del sistema
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository; 
    // Trae el repositorio para poder guardar, buscar, editar o eliminar restaurantes

    /**
     * Devuelve la lista de todos los restaurantes guardados en la base de datos.
     */
    public List<Restaurante> obtenerTodos() {
        return restauranteRepository.findAll();
    }

    /**
     * Busca un restaurante por su ID.
     * Devuelve un Optional, que puede tener el restaurante o estar vacío si no existe.
     */
    public Optional<Restaurante> obtenerPorId(Long id) {
        return restauranteRepository.findById(id);
    }

    /**
     * Guarda un nuevo restaurante en la base de datos.
     */
    public Restaurante crear(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    /**
     * Actualiza un restaurante existente con nuevos datos.
     * Si no existe, devuelve null.
     */
    public Restaurante actualizar(Long id, Restaurante actualizado) {
        return restauranteRepository.findById(id).map(restaurante -> {
            restaurante.setNombre(actualizado.getNombre());
            restaurante.setDireccion(actualizado.getDireccion());
            restaurante.setTelefono(actualizado.getTelefono());
            return restauranteRepository.save(restaurante); // Guarda los cambios
        }).orElse(null); // Si no lo encuentra, devuelve null
    }

    /**
     * Elimina un restaurante por su ID.
     */
    public void eliminar(Long id) {
        restauranteRepository.deleteById(id);
    }

    /**
     * Guarda varios restaurantes a la vez.
     */
    public List<Restaurante> guardarTodos(List<Restaurante> restaurantes) {
        return restauranteRepository.saveAll(restaurantes);
    }
}
