package com.grupo6.inventario_ms.controllers;

import com.grupo6.inventario_ms.exceptions.ProductNotFoundException;
import com.grupo6.inventario_ms.models.Product;
import com.grupo6.inventario_ms.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    
    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        //Seed
        Product product001 = new Product("001",  "Alicates", 1000, 20000 );
        Product product002 = new Product("002",  "Martillo", 500, 30000);

        this.productRepository.save(product001);
        this.productRepository.save(product002);
    }

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable String id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("El producto con ID \"" + id + "\" no existe."));
    }

    @PostMapping("/products/create")
    Product createProduct(@RequestBody Product product){
        Product newProduct = productRepository.findById(product.getId()).orElse(null);

        if (newProduct != null)
            throw new ProductNotFoundException("El producto con ID \"" + newProduct.getId() + "\" ya existe.");

        return productRepository.save(product);

    }



    @DeleteMapping("/products/delete/{id}")
    String deleteProduct(@PathVariable String id)
    {
        Product newProduct = productRepository.findById(id).orElse(null);

        if (newProduct == null)
            throw new ProductNotFoundException("El producto con ID \"" + id + "\" no existe.");
        productRepository.deleteById(id);

        return "El producto con ID \"" + id + "\" fue eliminado exitosamente.";
    }


}
