package com.wch.account.exception;

import com.wch.account.enums.errorenums.ErrorLevelCodeEnum;
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
public class BusinessInfoException extends BusinessBaseException{
    /**
     * 信息级别代码
     */
    private final String errorLevelCode= ErrorLevelCodeEnum.ERROR.getCode();

    public BusinessInfoException(HttpStatus httpStatus, String basicErrorCode, Throwable cause) {
        super(httpStatus, basicErrorCode, cause);
    }

    public BusinessInfoException(HttpStatus httpStatus, String basicErrorCode) {
        super(httpStatus, basicErrorCode);
    }

    public BusinessInfoException(BasicProcessException basicProcessException) {
        super(basicProcessException);
    }

    public BusinessInfoException(@NonNull String basicErrorCode) {
        super(basicErrorCode);
    }
}
