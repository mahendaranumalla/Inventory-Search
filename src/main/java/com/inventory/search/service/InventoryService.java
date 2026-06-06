package com.inventory.search.service;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventorySearchRequestDto;
import com.inventory.search.dto.InventorySearchResponseDto;
import com.inventory.search.filters.InventorySpecification;
import com.inventory.search.mappers.InventoryMapper;
import com.inventory.search.mappers.PageableFactory;
import com.inventory.search.repo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;
    private final PageableFactory pageableFactory;

    @Transactional(readOnly = true)
    public InventorySearchResponseDto search(
            InventorySearchRequestDto request) {

        Pageable pageable =
                pageableFactory.create(
                        request.getPagination(),
                        request.getSorting());

       return InventoryMapper.toResponse(
               repository.findAll(InventorySpecification.filter(request),pageable),
               pageable, pageable.getSort());
    }
}
