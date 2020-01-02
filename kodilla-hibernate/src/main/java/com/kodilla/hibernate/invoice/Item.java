package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {
    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    public Item(BigDecimal price, int quantity, BigDecimal value, Product product, Invoice invoice) {
        this.price = price;
        this.quantity = quantity;
        this.value = value;
        this.product = product;
        this.invoice = invoice;
    }

    public Item() {
    }

    @Id
    @GeneratedValue
    @Column(name = "item_id", unique = true)
    public int getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    @NotNull
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    @NotNull
    @Column(name = "value")
    public BigDecimal getValue() {
        return value;
    }

    
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    public Invoice getInvoice() {
        return invoice;
    }

    private void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    
    
    private void setId(int id) {
        this.id = id;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }
    
    public void addToProductAndInvoice() {
        product.getItems().add(this);
        invoice.getItems().add(this);
    }
}
