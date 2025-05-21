package com.example.Pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Pedido.model.Pedido;

// esta interfaz es un componente de repositorio,
//  la parte encargada de comunicarse con la base de datos.
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
