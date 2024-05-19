package bookservice.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(MsException.class)
    public ResponseEntity<?> exceptionHandler(MsException ex) {

        String userMessage;

        if (ex.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR) {
            log.error(ex.getInternalMessage());
            userMessage = "An error occurred. Please try again later.";
        } else {
            userMessage = ex.getUserMessage();

            if (ex.getInternalMessage() != null)
                userMessage = userMessage.concat(". ")
                        .concat(ex.getInternalMessage());
        }

        return new ResponseEntity<>(new ErrorMessage(ex.getCode(), userMessage, null), ex.getHeaders(), ex.getStatus());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle(BookNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}