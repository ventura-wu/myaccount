package com.wch.account.exception;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializerBase;
import com.wch.account.enums.ErrorLevelCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * 业务处理异常超类，定义了业务处理异常的结构
 *
 * @author c
 * @date 2021/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessBaseException extends RuntimeException {
    private static final String PRODUCT_CODE = "01";

    private final HttpStatus httpStatus;

    /**
     * 错误之间的分隔符
     */
    public static final String SEPARATOR = "-";

    /**
     * 错误级别代码
     */
    private final String errorLevelCode;

    /**
     * 基础异常代码
     */
    @NonNull
    private final String basicErrorCode;

    public BusinessBaseException(HttpStatus httpStatus, String basicErrorCode, Throwable cause) {
        super(cause);
        this.httpStatus = httpStatus;
        this.basicErrorCode = basicErrorCode;
        this.errorLevelCode = null;
    }

    public BusinessBaseException(HttpStatus httpStatus, String basicErrorCode) {
        this.httpStatus = httpStatus;
        this.basicErrorCode = basicErrorCode;
        this.errorLevelCode = null;
    }

    public BusinessBaseException(BasicProcessException basicProcessException) {
        this.httpStatus = BasicProcessException.HTTP_STATUS;
        this.basicErrorCode = basicProcessException.getBasicErrorCode();
        this.errorLevelCode = null;

    }

    public BusinessBaseException(@NonNull String basicErrorCode) {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.basicErrorCode = basicErrorCode;
        this.errorLevelCode = null;
    }

    public BusinessBaseException(String message, @NonNull String basicErrorCode) {
        super(message);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.basicErrorCode = basicErrorCode;
        this.errorLevelCode = null;
    }

    public BusinessBaseException() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorLevelCode = null;
        this.basicErrorCode = "0000";
    }

    public String getFullErrorCode() {
        return PRODUCT_CODE +
                SEPARATOR +
                (StringUtils.hasText(this.getErrorLevelCode()) ? ErrorLevelCodeEnum.UNKNOWN.getCode() : this.getErrorLevelCode()) +
                SEPARATOR +
                this.getBasicErrorCode();

    }
}
