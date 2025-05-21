package com.example.Usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Usuario.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}