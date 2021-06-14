package com.mycompany.note.domain.exception;

public class RepositoryExtension extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RepositoryExtension(String message) {
        super(message);
    }

}
