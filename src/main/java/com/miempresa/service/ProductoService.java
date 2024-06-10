package com.miempresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.model.Producto;
import com.miempresa.repository.IProducto;

@Service
public class ProductoService {

    @Autowired
    private IProducto productoRepo;

    public Producto save(Producto producto) {
        return productoRepo.save(producto);
    }

    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    public List<Producto> findByCategoriaId(Long categoriaId) {
        return productoRepo.findByCategoriaId(categoriaId);
    }
}
