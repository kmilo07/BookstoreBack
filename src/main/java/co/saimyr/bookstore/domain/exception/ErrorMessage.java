package co.saimyr.bookstore.domain.exception;

import java.util.Date;

public class ErrorMessage {

    private int statusCode;
    private Date time;
    private String message;

    public ErrorMessage(int statusCode, Date time, String message) {
        this.statusCode = statusCode;
        this.time = time;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Date getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
