package com.example.Pedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pedido.model.Pedido;
import com.example.Pedido.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service // aquí va la lógica del sistema.
public class PedidoService {

    @Autowired // pone repositorio automáticamente 
    private PedidoRepository pedidoRepository;

    // Método para obtener todos los pedidos desde la base de datos.
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    // Método para obtener un pedido específico por su ID.
    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Método para crear y guardar un nuevo pedido en la base de datos.
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Método para actualizar un pedido existente.
    // Si el pedido con ese ID existe, lo actualiza si no  devuelve null.
    public Pedido actualizarPedido(Long id, Pedido actualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setFecha(actualizado.getFecha());
            pedido.setTotal(actualizado.getTotal());
            pedido.setUsuarioId(actualizado.getUsuarioId());
            return pedidoRepository.save(pedido); // Guarda los cambios
        }).orElse(null); // Si no existe, devuelve null 
    }

    // Método para eliminar un pedido por ID.
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    // Método para guardar varios pedidos de una sola vez.
    public List<Pedido> guardarTodos(List<Pedido> pedidos) {
        return pedidoRepository.saveAll(pedidos);
    }
}
