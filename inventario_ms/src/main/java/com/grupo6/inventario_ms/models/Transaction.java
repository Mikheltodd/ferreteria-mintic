package com.grupo6.inventario_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String id;

    private String productId;
    private String type;
    private Integer quantity;
    private Date date;

    public Transaction(String id, String type, Integer quantity, Date date) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
