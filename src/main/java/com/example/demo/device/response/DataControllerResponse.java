package com.example.demo.device.response;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DataControllerResponse<T> {
    private String status;
    private String message;
    private int code;
    private T data;
    private LocalDateTime dateTime;

    public DataControllerResponse(String status, String message, int code, T data, LocalDateTime dateTime) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.data = data;
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataControllerResponse<?> that = (DataControllerResponse<?>) o;
        return code == that.code && Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, code, data);
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String formattedDateTime = dateTime.format(formatter);
        return "DataControllerResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", dateTime=" + formattedDateTime +
                '}';
    }
}