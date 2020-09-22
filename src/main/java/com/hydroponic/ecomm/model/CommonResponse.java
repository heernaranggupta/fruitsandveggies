package com.hydroponic.ecomm.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -397296984562869645L;

    private T body;
    private Integer code;
    private String message;
    private Boolean success;
    private LocalDateTime timestamp;

    public CommonResponse(T body) {
        this.body = body;
    }

    public CommonResponse(T body, int code, String message, Boolean success) {
        this.body = body;
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public CommonResponse(T body, Integer code, String message, Boolean success, LocalDateTime timestamp) {
        this.body = body;
        this.code = code;
        this.message = message;
        this.success = success;
        this.timestamp = timestamp;
    }

    public T getBody() {
        return body;
    }
}
