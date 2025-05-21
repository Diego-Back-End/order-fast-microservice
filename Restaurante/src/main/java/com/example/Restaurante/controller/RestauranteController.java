package com.example.Restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Restaurante.model.Restaurante;
import com.example.Restaurante.service.RestauranteService;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase se encarga de recibir las solicitudes que llegan al sistema 
 * (como GET, POST, PUT, DELETE) y las envía al servicio correspondiente para manejarlas.
 */
@RestController // esta clase recibe peticiones
@RequestMapping("/restaurantes") // Define la URL base para acceder a todo lo relacionado con restaurantes
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;
    // Trae el servicio para poder usar su lógica desde aquí

    /**
     * Obtiene y devuelve la lista completa de restaurantes.
     */
    @GetMapping
    public List<Restaurante> obtenerTodos() {
        return restauranteService.obtenerTodos();
    }

    /**
     * Obtiene un restaurante según su ID.
     */
    @GetMapping("/{id}")
    public Optional<Restaurante> obtenerPorId(@PathVariable Long id) {
        return restauranteService.obtenerPorId(id);
    }

    /**
     * Crea un nuevo restaurante con los datos que recibe en el cuerpo de la solicitud.
     * URL: POST /restaurantes
     */
    @PostMapping
    public Restaurante crear(@RequestBody Restaurante restaurante) {
        return restauranteService.crear(restaurante);
    }

    /**
     * Actualiza un restaurante existente según su ID
     */
    @PutMapping("/{id}")
    public Restaurante actualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return restauranteService.actualizar(id, restaurante);
    }

    /**
     * Elimina un restaurante por su ID.

     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        restauranteService.eliminar(id);
    }

    /**
     * Guarda una lista de restaurantes.
     */
    @PostMapping("/bulk")
    public List<Restaurante> guardarVarios(@RequestBody List<Restaurante> restaurantes) {
        return restauranteService.guardarTodos(restaurantes);
    }
}
