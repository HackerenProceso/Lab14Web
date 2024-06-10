package com.miempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miempresa.model.Carrito;

public interface ICarrito extends JpaRepository<Carrito, Long> {
}
