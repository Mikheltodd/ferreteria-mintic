package com.grupo6.inventario_ms.repositories;


import com.grupo6.inventario_ms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, String> {
}
