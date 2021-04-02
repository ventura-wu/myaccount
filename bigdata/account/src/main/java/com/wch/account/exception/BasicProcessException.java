package com.wch.account.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 基础处理异常类，basicErrorCode由string自定义
 *
 * @author c
 * @date 2021/4/3
 */
@Getter
@Setter
public class BasicProcessException extends Exception {
    protected static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
    @NonNull
    private final String basicErrorCode;

    public BasicProcessException(@NonNull String basicErrorCode) {
        this.basicErrorCode = "0000";
    }

    public BasicProcessException(String message, @NonNull String basicErrorCode) {
        super(message);
        this.basicErrorCode = basicErrorCode;
    }

    public BasicProcessException(String message, Throwable cause, @NonNull String basicErrorCode) {
        super(message, cause);
        this.basicErrorCode = basicErrorCode;
    }

    public BasicProcessException(Throwable cause, @NonNull String basicErrorCode) {
        super(cause);
        this.basicErrorCode = basicErrorCode;
    }
}
