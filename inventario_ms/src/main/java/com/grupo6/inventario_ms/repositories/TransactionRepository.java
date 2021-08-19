package com.grupo6.inventario_ms.repositories;


import com.grupo6.inventario_ms.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
