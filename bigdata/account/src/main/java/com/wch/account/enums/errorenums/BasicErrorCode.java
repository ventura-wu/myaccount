package com.wch.account.enums.errorenums;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;

/**
 * @author c
 * @date 2021/4/3
 */
public enum BasicErrorCode {
    BASIC_NOT_FOUND_EXCEPTION("1001","资源未找到"),
    RESOURCE_NOT_EXIST("1002","资源不存在"),
    USER_EXISTED("1003","用户已经存在"),
    ;
    private String errorCode;
    private String errorDescription;

    BasicErrorCode(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public static String getDescByCode(String errorCode){
        return  Arrays.stream(BasicErrorCode.values()).filter(e->StringUtils.equals(e.getErrorCode(),errorCode)).findAny()
                .map(BasicErrorCode::getErrorDescription).orElse(errorCode);
    }
}
