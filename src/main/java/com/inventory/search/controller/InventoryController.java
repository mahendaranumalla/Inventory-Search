package com.inventory.search.controller;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventorySearchRequestDto;
import com.inventory.search.dto.InventorySearchResponseDto;
import com.inventory.search.dto.PaginationDto;
import com.inventory.search.dto.SortingDto;
import com.inventory.search.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/search")
    public InventorySearchResponseDto search(@Valid @RequestBody InventorySearchRequestDto request) {
        log.trace("search request received "+ request);
        return inventoryService.search(request);
    }
}
