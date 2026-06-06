package com.inventory.search;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventorySearchRequestDto;
import com.inventory.search.dto.InventorySearchResponseDto;
import com.inventory.search.filters.InventorySpecification;
import com.inventory.search.mappers.InventoryMapper;
import com.inventory.search.mappers.PageableFactory;
import com.inventory.search.model.Inventory;
import com.inventory.search.repo.InventoryRepository;
import com.inventory.search.service.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventoryServiceTest {

    @Mock
    private InventoryRepository repository;

    @Mock
    private PageableFactory pageableFactory;

    @InjectMocks
    private InventoryService inventoryService;

    private InventorySearchRequestDto request;

    @BeforeEach
    void setUp() {
        request = mock(InventorySearchRequestDto.class);
    }

    @Test
    void shouldReturnSearchResponseSuccessfully() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 10, Sort.by("name"));

        Page<Inventory> pageResult = new PageImpl<>(java.util.List.of());

        when(pageableFactory.create(any(), any()))
                .thenReturn(pageable);
        Specification<Inventory> spec = InventorySpecification.filter(request);
        when(repository.findAll(spec, eq(pageable)))
                .thenReturn(pageResult);

        InventorySearchResponseDto expectedResponse = mock(InventorySearchResponseDto.class);

        try (MockedStatic<InventoryMapper> mockedMapper = mockStatic(InventoryMapper.class)) {

            mockedMapper.when(() ->
                    InventoryMapper.toResponse(pageResult, pageable, pageable.getSort())
            ).thenReturn(expectedResponse);

            // Act
            InventorySearchResponseDto actual =
                    inventoryService.search(request);

            // Assert
            assertNotNull(actual);
            assertEquals(expectedResponse, actual);

            verify(repository, times(1))
                    .findAll(spec, eq(pageable));

            verify(pageableFactory, times(1))
                    .create(any(), any());
        }
    }

    @Test
    void shouldCallRepositoryWithSpecification() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 5);

        when(pageableFactory.create(any(), any()))
                .thenReturn(pageable);
        Specification<Inventory> spec = InventorySpecification.filter(request);
        when(repository.findAll(spec, eq(pageable)))
                .thenReturn(new PageImpl<>(java.util.List.of()));

        try (MockedStatic<InventoryMapper> mockedMapper = mockStatic(InventoryMapper.class)) {

            mockedMapper.when(() ->
                    InventoryMapper.toResponse(any(), any(), any())
            ).thenReturn(mock(InventorySearchResponseDto.class));

            // Act
            inventoryService.search(request);

            // Assert
            verify(repository).findAll(spec, eq(pageable));
        }
    }

    /*@Test
    void shouldHandleEmptyResults() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 10);

        when(pageableFactory.create(any(), any()))
                .thenReturn(pageable);

        when(repository.findAll(any(), eq(pageable)))
                .thenReturn(new PageImpl<>(java.util.List.of()));

        try (MockedStatic<InventoryMapper> mockedMapper = mockStatic(InventoryMapper.class)) {

            mockedMapper.when(() ->
                    InventoryMapper.toResponse(any(), any(), any())
            ).thenReturn(mock(InventorySearchResponseDto.class));

            // Act
            InventorySearchResponseDto result =
                    inventoryService.search(request);

            // Assert
            assertNotNull(result);
        }
    }*/
}
