package com.inventory.search.dto;/* Created by manumalla on 06-06-2026. */

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Value
@Data
@Builder
public class InventorySearchResponseDto {

    private List<InventoryItemResponseDto> items;

    private PaginationDto pagination;

    private SortingDto sorting;
}
