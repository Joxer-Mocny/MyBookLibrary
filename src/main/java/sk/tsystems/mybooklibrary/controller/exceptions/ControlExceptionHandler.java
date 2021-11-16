package sk.tsystems.mybooklibrary.controller.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j

public class ControlExceptionHandler {
    @ExceptionHandler(value = ForbiddenTitleException.class)
    public ResponseEntity<Void> handleForbiddenBookException(RuntimeException e, WebRequest webRequest){
        log.error("Forbidden book! {}. Error message: {}",
                webRequest.getDescription(false),
            e.getMessage(),
            e.getCause());
        return ResponseEntity.status(400).build();
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Void> handleGeneralException(Exception e, WebRequest webRequest) {
        log.error("Unhandled exception occurred during {}. Error message: {}",
                webRequest.getDescription(false),
                e.getMessage(),
                e.getCause());
        return ResponseEntity.internalServerError().build();
    }
}
