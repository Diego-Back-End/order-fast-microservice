package com.example.Usuario.model;

// Importaciones necesarias para usar JPA y Lombok(base de datos)
import jakarta.persistence.*; // Permite mapear esta clase como una entidad de base de datos
import lombok.AllArgsConstructor; // Genera automáticamente un constructor con todos los atributos
import lombok.Data; // Genera getters, setters, toString, equals y hashCode automáticamente
import lombok.NoArgsConstructor; // Genera un constructor vacío


@Entity// esta clase se va a guardar en la base de datos como una tabla
@Table(name = "usuarios")  // Le pone el nombre "usuarios" a la tabla
@Data 
@AllArgsConstructor //crea un constructor en todos los campos
@NoArgsConstructor // se crea constructor vacio para que el jpa funcione correctamente
public class Usuario {

    // este es el id del usuario se generara solo que nos servira para idientificar a cada usuario
    @Id // id principal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false) //este campo no puede ser nulo
    private String nombre;

    @Column(nullable = false) //este campo no puede ser nulo
    private String email;

     
    
}