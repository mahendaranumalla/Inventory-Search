package com.inventory.search.exceptions;/* Created by manumalla on 06-06-2026. */


public class SearchException extends RuntimeException {
    public SearchException(String message) {
        super(message);
    }

    public SearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
