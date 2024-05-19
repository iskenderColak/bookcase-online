package bookservice.exception;

import org.springframework.http.HttpStatus;

public class MsNotFoundException extends MsException {
    public MsNotFoundException(ExceptionCodes code, String userMessage) {
        super(code, HttpStatus.NOT_FOUND, userMessage);
    }
}