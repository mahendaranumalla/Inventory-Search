package com.inventory.search.model;/* Created by manumalla on 06-06-2026. */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private String subcategory;

    private LocalDate manufacturingDate;

    private LocalDate expiryDate;

    @Column(length = 2000)
    private String specification;

    private BigDecimal price;

    private Integer stock;

    private String model;

    private String seller;

    private String location;
}
