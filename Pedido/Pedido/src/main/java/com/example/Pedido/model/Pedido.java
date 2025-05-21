package com.example.Pedido.model;

import jakarta.persistence.*; // Anotaciones de JPA para conectar con la base de datos
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // Genera automáticamente los getters, setters, toString
@AllArgsConstructor // Genera un constructor con todos los campos
@NoArgsConstructor // Genera un constructor vacío (sin parámetros)
@Entity // Indica que esta clase es una entidad JPA (se mapeará a una tabla en la base de datos)
@Table(name = "pedidos") // Le dice a JPA que esta entidad se guarda en una tabla llamada "pedidos"
public class Pedido {

    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Hace que el ID se genere automáticamente
    private Long id;

    @Column(nullable = true)
    private LocalDate fecha; // Fecha del pedido, Puede ser nula, por eso se permite.

    private double total; // Monto total del pedido

    @Column(nullable = false)
    private Long usuarioId; // ID del usuario que hizo el pedido (no puede ser nulo)
}
