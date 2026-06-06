package com.inventory.search.mappers;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.PaginationDto;
import com.inventory.search.dto.SortingDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PageableFactory {

    public Pageable create(PaginationDto pagination, SortingDto sorting) {

        PaginationDto finalPagination =
                Optional.ofNullable(pagination)
                        .orElse(new PaginationDto(0, 10));

        SortingDto finalSorting =
                Optional.ofNullable(sorting)
                        .orElse(new SortingDto("name", "ASC"));

        Sort sort = Sort.by(
                Sort.Direction.fromString(finalSorting.getOrder()),
                finalSorting.getField()
        );

        return PageRequest.of(
                finalPagination.getPage(),
                finalPagination.getSize(),
                sort
        );
    }
}
