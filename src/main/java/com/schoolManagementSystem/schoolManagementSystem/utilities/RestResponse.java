package com.schoolManagementSystem.schoolManagementSystem.utilities;

import lombok.Data;
import org.springframework.http.ResponseEntity;
@Data
public class RestResponse<T>  {
    private int status;
    private String message;
    private T data;

    // Private constructor to prevent direct instantiation
    private RestResponse() {
//        super(this.status,);
    }

    // Getter methods for status, message, and data

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    // Builder class for fluent API
    public static class Builder<T> {
        private int status;
        private String message;
        private T data;

        private Builder() {}

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public RestResponse<T> build() {
            RestResponse<T> response = new RestResponse<>();
            response.status = this.status;
            response.message = this.message;
            response.data = this.data;
            return response;
        }
    }
}
