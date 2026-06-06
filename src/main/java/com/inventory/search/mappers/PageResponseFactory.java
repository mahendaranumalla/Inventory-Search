package com.inventory.search.mappers;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.PaginationDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PageResponseFactory {

    public static PaginationDto from(Pageable pageable) {
        PaginationDto paginationDto = new PaginationDto();
        paginationDto.setPage(pageable.getPageSize());
        paginationDto.setSize(pageable.getPageNumber());

        return paginationDto;
    }
}
