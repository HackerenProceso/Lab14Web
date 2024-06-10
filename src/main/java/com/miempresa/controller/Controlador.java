package com.miempresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.miempresa.model.Categoria;
import com.miempresa.model.Producto;
import com.miempresa.service.CarritoService;
import com.miempresa.service.CategoriaService;
import com.miempresa.service.ProductoService;

@Controller
public class Controlador {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProductoService productoService;


    @Autowired
    private CarritoService carritoService;
    
    
    @GetMapping("/")
    public String index(Model model) {
        //Categoria categoria = new Categoria();
    	//categoria.setNombre("Electrónicos");
    	//categoria.setDescripcion("Celulares y dispositivos");

    	//categoriaService.save(categoria);

    	//Producto producto1 = new Producto();
    	//producto1.setNombre("Smartphone");
    	//producto1.setDescripcion("Llevate el ultimo cell con Snapdragon #10");
    	//producto1.setPrecio(699.99);
    	//producto1.setUrlImagen("https://as2.ftcdn.net/v2/jpg/01/06/38/11/1000_F_106381187_BTwzKKXGYaeCpAk92GQOyX4uYGCV4Ai5.jpg");
    	//producto1.setCategoria(categoria);

    	//Producto producto2 = new Producto();
    	//producto2.setNombre("Laptop");
    	//producto2.setDescripcion("Mejor procesador con la mejor refrigeración");
    	//producto2.setPrecio(1299.99);
    	//producto2.setUrlImagen("https://compusistemasperu.com/wp-content/uploads/2023/03/HPG8.jpg");
    	//producto2.setCategoria(categoria);

    	//productoService.save(producto1);
    	//productoService.save(producto2);

        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("categorias", categoriaService.findAll());
        return "index";
    }

    @GetMapping("/categoria")
    public String categoria(Long id, Model model) {
        Categoria categoria = categoriaService.findById(id);
        
        model.addAttribute("categoria", categoria);
        model.addAttribute("productos", productoService.findByCategoriaId(categoria.getId()));
        
        return "categoria";
    }
    
    @GetMapping("/carrito")
    public String carrito(Model model) {
        model.addAttribute("carritos", carritoService.findAll());
        return "carrito";
    }
}
