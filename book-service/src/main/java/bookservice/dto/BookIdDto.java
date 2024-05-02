package bookservice.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookIdDto {

    Integer bookId;
    String isbn;

    public BookIdDto(Integer bookId) {
        this.bookId = bookId;
    }
}
