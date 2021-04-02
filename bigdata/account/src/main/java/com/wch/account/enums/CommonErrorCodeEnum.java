package com.wch.account.enums;

/**
 * 公共异常状态码
 * @author c
 * @date 2021/4/3
 */
public enum CommonErrorCodeEnum {
    CANNOT_GET_JDBC_CONNECTION("0011","无法获取数据库连接"),
    BAD_SQL_GRAMMAR_EXCEPTION("0012","数据库查询语句有误"),
    DATA_ACCESS_EXCEPTION("0013","数据库拒绝访问"),
    INVALID_DATA_ACCESS_RESOURCE_USAGE_EXCEPTION("0014","数据库查询语句有误"),
    HYSTRIX_RUNTIME_EXCEPTION("0015","依赖调用有误"),
    ;
    private String code;
    private String message;

    CommonErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
