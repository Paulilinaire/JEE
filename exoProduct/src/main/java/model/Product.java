package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;

    private String brand;

    private LocalDate saleDate;

    private double price;

    private int storage;

    @Lob
    @Basic
    private byte[] image;

    public Product() {
    }

    public Product(String reference, String brand, LocalDate saleDate, double price, int storage, byte[] image) {
        this.reference = reference;
        this.brand = brand;
        this.saleDate = saleDate;
        this.price = price;
        this.storage = storage;
        this.image = image;
    }


}
