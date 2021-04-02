package com.wch.account.exception;

import com.wch.account.enums.ErrorLevelCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

/**
 * 业务错误级别的异常
 * @author c
 * @date 2021/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessErrorException extends BusinessBaseException{
    /**
     * 错误级别代码
     */
    private final String errorLevelCode= ErrorLevelCodeEnum.ERROR.getCode();

    public BusinessErrorException(HttpStatus httpStatus, String basicErrorCode, Throwable cause) {
        super(httpStatus, basicErrorCode, cause);
    }

    public BusinessErrorException(HttpStatus httpStatus, String basicErrorCode) {
        super(httpStatus, basicErrorCode);
    }

    public BusinessErrorException(BasicProcessException basicProcessException) {
        super(basicProcessException);
    }

    public BusinessErrorException(@NonNull String basicErrorCode) {
        super(basicErrorCode);
    }
}
