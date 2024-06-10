package com.miempresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miempresa.model.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer>{
	Usuario findByNombre(String nombre);
}
