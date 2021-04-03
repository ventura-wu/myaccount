package com.wch.account.enums.errorenums;


/**
 * @author c
 * @date 2021/4/3
 */
public enum ErrorLevelCodeEnum {
    UNKNOWN("00"),
    ERROR("01"),
    WARNING("02"),
    INFO("03");
    private String code;
    ErrorLevelCodeEnum(String code){this.code=code;}
    public String getCode(){
        return code;
    }
}
