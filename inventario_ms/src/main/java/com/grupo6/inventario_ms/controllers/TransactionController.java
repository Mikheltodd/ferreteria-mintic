package com.grupo6.inventario_ms.controllers;

import com.grupo6.inventario_ms.exceptions.InsufficientQuantityException;
import com.grupo6.inventario_ms.exceptions.ProductNotFoundException;
import com.grupo6.inventario_ms.models.Product;
import com.grupo6.inventario_ms.models.Transaction;
import com.grupo6.inventario_ms.repositories.TransactionRepository;
import com.grupo6.inventario_ms.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TransactionController {

    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    public TransactionController(ProductRepository productRepository, TransactionRepository transactionRepository) {
        this.productRepository = productRepository;
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/transactions/new")
    Transaction newTransaction(@RequestBody Transaction transaction) {
        Product product = productRepository.findById(transaction.getProductId()).orElse(null);

        if (product == null)
            throw new ProductNotFoundException("El producto con ID \"" + transaction.getProductId() + "\" no fue encontrado.");

        if(transaction.getType().equals("sell")) {
            if(product.getQuantity() < transaction.getQuantity())
                throw new InsufficientQuantityException("No se tiene la suficiente cantidad de producto en el inventario.");
            product.setQuantity(product.getQuantity() - transaction.getQuantity());
        }
        if(transaction.getType().equals("buy"))
            product.setQuantity(product.getQuantity() + transaction.getQuantity());


        productRepository.save(product);
        transaction.setDate(new Date());
        return transactionRepository.save(transaction);
    }
}
