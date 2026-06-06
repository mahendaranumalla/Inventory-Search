package com.inventory.search.dto;/* Created by manumalla on 06-06-2026. */
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}