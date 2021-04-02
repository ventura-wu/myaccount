package com.wch.account.enums;

/**
 * 逻辑删除状态
 * @author c
 * @date 2021/4/3
 */
public enum DeleteEnum {
    NORMAL(0,"正常"),
    DELETED(1,"已删除"),
    ;
    private Integer type;
    private String description;

    DeleteEnum(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
