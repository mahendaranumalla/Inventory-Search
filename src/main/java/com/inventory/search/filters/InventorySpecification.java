package com.inventory.search.filters;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.InventorySearchRequestDto;
import com.inventory.search.model.Inventory;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InventorySpecification {

    public static Specification<Inventory> filter(
            InventorySearchRequestDto req) {

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(req.getKeyword() != null) {

                String pattern =
                        "%" + req.getKeyword().toLowerCase() + "%";

                predicates.add(
                        cb.or(
                                cb.like(cb.lower(root.get("name")), pattern),
                                cb.like(cb.lower(root.get("specification")), pattern),
                                cb.like(cb.lower(root.get("model")), pattern),
                                cb.like(cb.lower(root.get("seller")), pattern)
                        )
                );
            }

            if(req.getCategory() != null) {
                predicates.add(
                        cb.equal(root.get("category"),
                                req.getCategory())
                );
            }

            if(req.getSubcategory() != null) {
                predicates.add(
                        cb.equal(root.get("subcategory"),
                                req.getSubcategory())
                );
            }

            if(req.getSeller() != null) {
                predicates.add(
                        cb.equal(root.get("seller"),
                                req.getSeller())
                );
            }

            if(req.getLocation() != null) {
                predicates.add(
                        cb.equal(root.get("location"),
                                req.getLocation())
                );
            }

            if(req.getMinPrice() != null) {
                predicates.add(
                        cb.greaterThanOrEqualTo(
                                root.get("price"),
                                req.getMinPrice())
                );
            }

            if(req.getMaxPrice() != null) {
                predicates.add(
                        cb.lessThanOrEqualTo(
                                root.get("price"),
                                req.getMaxPrice())
                );
            }

            if(Boolean.TRUE.equals(req.getInStock())) {
                predicates.add(
                        cb.greaterThan(root.get("stock"), 0)
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
