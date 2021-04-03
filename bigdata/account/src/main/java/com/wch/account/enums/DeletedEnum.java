package com.wch.account.enums;

/**
 * @author c
 * @date 2021/4/3
 */
public enum DeletedEnum {
    NORMAL(0,"未删除"),
    DELETED(1,"已删除"),
    ;
    private Integer type;
    private String description;

    DeletedEnum(Integer type, String description) {
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
