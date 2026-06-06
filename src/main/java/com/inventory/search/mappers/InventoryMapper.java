package com.inventory.search.mappers;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventoryItemResponseDto;
import com.inventory.search.dto.InventorySearchResponseDto;
import com.inventory.search.dto.PaginationDto;
import com.inventory.search.dto.SortingDto;
import com.inventory.search.model.Inventory;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryMapper {
    public static InventorySearchResponseDto toResponse(Page<Inventory> inventory, Pageable pageable, Sort sort){

                return InventorySearchResponseDto.builder()
                        .items(toDtoList(inventory))
                        .pagination(buildPagination(pageable))
                        .sorting(buildSorting(sort))
                        .build();
    }
/*
    public static InventorySearchResponseDto create(List<Inventory> inventory) {
        return InventorySearchResponseDto.builder()
                .items(InventoryMapper.toDtoList(inventory))
                .build();
    }*/



    public static List<InventoryItemResponseDto> toDtoList(Page<Inventory> inventoryList) {
        if (inventoryList == null) return List.of();

        return inventoryList.stream()
                .map(InventoryDtoFactory::toDto)
                .collect(Collectors.toList());
    }

    public static PaginationDto buildPagination(Pageable pageable){
         return   PageResponseFactory.from(pageable);
    }
    public static SortingDto buildSorting(Sort sort){
        Sort.Order field = sort.get().findFirst().orElse(null);
         return   new SortingDto(field.getProperty(),field.getDirection().name());
    }
}
