package com.example.productmanager.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    private String model;
    private String serialNumber;
}

