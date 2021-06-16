package com.mycompany.note.domain.exception;

import com.mycompany.note.domain.model.enums.ResourceType;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(ResourceType type, String id) {
        super(String.format("%s with %s id not found", type, id));
    }
}
