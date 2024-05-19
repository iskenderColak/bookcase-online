package bookservice.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    HttpStatus status;
    Integer code;
    String userMessage;
    String internalMessage;
    MultiValueMap<String, String> headers;

    public MsException(ExceptionCodes ex, HttpStatus status, String internalMessage) {
        super();
        this.setStatus(status);
        this.setCode(ex.getId());
        this.setUserMessage(ex.getMsg());
        this.setInternalMessage(internalMessage);
    }

    public MsException(ExceptionCodes ex, HttpStatus status, String internalMessage, MultiValueMap<String, String> headers) {
        super();
        this.setStatus(status);
        this.setCode(ex.getId());
        this.setUserMessage(ex.getMsg());
        this.setInternalMessage(internalMessage);
        this.setHeaders(headers);
    }

    public MsException() {
        super();
    }
}