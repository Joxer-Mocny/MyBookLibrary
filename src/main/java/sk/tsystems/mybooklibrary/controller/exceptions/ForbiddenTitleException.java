package sk.tsystems.mybooklibrary.controller.exceptions;

public class ForbiddenTitleException extends RuntimeException {
    public ForbiddenTitleException(String message) {
        super(message);
    }
}
