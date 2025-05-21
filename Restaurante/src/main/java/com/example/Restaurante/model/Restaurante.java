package com.example.Restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data  // Anotación de Lombok que genera todos los métodos estándar como getters y setters
@NoArgsConstructor // Genera un constructor con todos los atributos
@AllArgsConstructor // Genera un constructor vacío, requerido por JPA
@Entity // Marca esta clase como una entidad JPA que se mapeará a una tabla en la base de datos
@Table(name = "restaurantes")  // Define el nombre de la tabla en la base de datos como "restaurante"
public class Restaurante {

    @Id //indica que este atributo es la clave priamria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // El ID se autogenera

    private Long id;

    @Column(nullable = false) //  no puede ser nulo
    private String nombre;

    @Column(nullable = false) //  no puede ser nulo
    private String direccion;

    @Column(nullable = false) // no puede ser nulo
    private String telefono;


}
