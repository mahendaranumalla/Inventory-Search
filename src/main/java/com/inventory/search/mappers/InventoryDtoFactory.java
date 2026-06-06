package com.inventory.search.mappers;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventoryItemResponseDto;
import com.inventory.search.model.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryDtoFactory {

    public static InventoryItemResponseDto toDto(Inventory entity) {
        if (entity == null) {
            return null;
        }
        return InventoryItemResponseDto.builder()
                /*.id(entity.getId())*/
                .name(entity.getName())
                .category(entity.getCategory())
                .subcategory(entity.getSubcategory())
                .manufacturingDate(entity.getManufacturingDate())
                .expiryDate(entity.getExpiryDate())
                .specification(entity.getSpecification())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .model(entity.getModel())
                .seller(entity.getSeller())
                .location(entity.getLocation())
                .inStock(entity.getStock() != null && entity.getStock() > 0)
                .build();
    }
}
