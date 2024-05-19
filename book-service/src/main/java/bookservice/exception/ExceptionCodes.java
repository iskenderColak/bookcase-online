package bookservice.exception;

public enum ExceptionCodes {

    BOOK_NOT_FOUND(402, "Book not found with this criteria")
    ;

    final int id;
    final String msg;

    ExceptionCodes(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}