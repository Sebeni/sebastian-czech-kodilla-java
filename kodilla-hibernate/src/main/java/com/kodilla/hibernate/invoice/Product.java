package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();
    
    public Product(String name) {
        this.name = name;
    }
    
    public Product() {
    }

    @Id
    @GeneratedValue
    @Column(name = "product_id", unique = true)
    public int getId() {
        return id;
    }
    
    @Column(name = "product_name")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
