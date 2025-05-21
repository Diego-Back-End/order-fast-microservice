package com.example.Usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Usuario.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Puedes agregar consultas personalizadas si lo necesitas
}