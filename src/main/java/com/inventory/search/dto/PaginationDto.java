package com.inventory.search.dto;/* Created by manumalla on 06-06-2026. */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {

    private Integer page;

    private Integer size;

   /* private Long totalElements;

    private Integer totalPages;

    private Boolean hasNext;

    private Boolean hasPrevious;*/



}
