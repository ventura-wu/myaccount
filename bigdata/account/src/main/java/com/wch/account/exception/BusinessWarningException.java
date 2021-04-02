package com.wch.account.exception;

import com.wch.account.enums.ErrorLevelCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

/**
 * 业务信息级别的异常
 * @author c
 * @date 2021/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessWarningException extends BusinessBaseException{
    /**
     * 警告级别代码
     */
    private final String errorLevelCode= ErrorLevelCodeEnum.WARNING.getCode();

    public BusinessWarningException(HttpStatus httpStatus, String basicErrorCode, Throwable cause) {
        super(httpStatus, basicErrorCode, cause);
    }

    public BusinessWarningException(HttpStatus httpStatus, String basicErrorCode) {
        super(httpStatus, basicErrorCode);
    }

    public BusinessWarningException(BasicProcessException basicProcessException) {
        super(basicProcessException);
    }

    public BusinessWarningException(@NonNull String basicErrorCode) {
        super(basicErrorCode);
    }
}
