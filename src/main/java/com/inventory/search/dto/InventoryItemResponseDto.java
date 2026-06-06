package com.inventory.search.dto;/* Created by manumalla on 06-06-2026. */

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class InventoryItemResponseDto {

   /* private Long id;*/
    private String name;
    private String category;
    private String subcategory;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private String specification;
    private BigDecimal price;
    private Integer stock;
    private String model;
    private String seller;
    private String location;
    private Boolean inStock;
}
