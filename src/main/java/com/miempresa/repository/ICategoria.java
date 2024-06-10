package com.miempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miempresa.model.Categoria;

public interface ICategoria extends JpaRepository<Categoria, Long> {

}
