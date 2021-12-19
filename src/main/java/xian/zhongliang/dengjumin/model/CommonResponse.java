package xian.zhongliang.dengjumin.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonResponse<T> {

    private static String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss.SSS";
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    private int status;

    private String message;

    private T result;

    private String timestamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public CommonResponse() {
    }

    public CommonResponse(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.timestamp = LocalDateTime.now().format(dateTimeFormatter);
    }
}
