/* Created by manumalla on 06-06-2026. */
package com.inventory.search.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Data
public class InventorySearchRequestDto {

    @Size(max = 50, message = "Keyword cannot exceed 100 characters")
    private String keyword;
    @Size(max = 50, message = "Category cannot exceed 50 characters")
    private String category;

    @Size(max = 50, message = "Subcategory cannot exceed 50 characters")
    private String subcategory;

    @Size(max = 50, message = "Model cannot exceed 100 characters")
    private String model;

    @Size(max = 50, message = "Seller cannot exceed 100 characters")
    private String seller;

    @Size(max = 50, message = "Location cannot exceed 100 characters")
    private String location;

    @DecimalMin(value = "0.0", message = "Min price must be >= 0")
    private BigDecimal minPrice;

    @DecimalMin(value = "0.0", message = "Max price must be >= 0")
    private BigDecimal maxPrice;

    private LocalDate manufacturedAfter;

    private LocalDate expiryBefore;

    private Boolean inStock;

    // @Valid  should be done
    private PaginationDto pagination;

    private SortingDto sorting;
}
