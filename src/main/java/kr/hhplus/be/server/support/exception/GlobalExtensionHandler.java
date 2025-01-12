package kr.hhplus.be.server.support.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice("kr.hhplus.be.server")
public class GlobalExtensionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleProductNotFound(NotFoundException extension) {
        return new ResponseEntity<>(extension.getMessage(), HttpStatus.NOT_FOUND);
    }

}

