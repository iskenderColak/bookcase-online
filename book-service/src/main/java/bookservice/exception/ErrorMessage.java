package bookservice.exception;

import java.util.List;

public record ErrorMessage(Integer code, String message, List<Error> errors) {

    public record Error(String field, String message) {
    }
}

//@Data
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ErrorMessage {
//
//    Integer code;
//    String message;
//    List<Error> errors;
//
//    @Data
//    @AllArgsConstructor
//    public static class Error {
//        String field;
//        String message;
//    }
//}