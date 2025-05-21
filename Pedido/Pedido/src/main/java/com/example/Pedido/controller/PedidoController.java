package com.example.Pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Pedido.model.Pedido;
import com.example.Pedido.service.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/pedidos") // Todas las rutas van a partir de  /pedidos
public class PedidoController {

    // servicio para usar la lógica de negocio
    @Autowired
    private PedidoService pedidoService;

    // Devuelve todos los pedidos porque
    @GetMapping
    public List<Pedido> obtenerTodos() {
        return pedidoService.obtenerTodos();
    }

    // Devuelve un pedido por su ID
    @GetMapping("/{id}")
    public Optional<Pedido> obtenerPorId(@PathVariable Long id) {
        return pedidoService.obtenerPorId(id);
    }

    // Crea un nuevo pedido.
    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    // Actualiza un pedido si existe
    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        return pedidoService.actualizarPedido(id, pedido);
    }

    // Elimina un pedido
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }

    //  Guarda varios pedidos 
    @PostMapping("/bulk")
    public List<Pedido> guardarVarios(@RequestBody List<Pedido> pedidos) {
        return pedidoService.guardarTodos(pedidos);
    }

}
