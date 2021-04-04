package com.wch.account.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author c
 * @date 2021/4/4
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResponse {
    @NotNull
    private Integer status;
    private String errorCode;
    private String userMessage;

    public BaseResponse() {
        this.status = 200;
    }

    public BaseResponse(@NotNull Integer status) {
        this.status = status;
    }

    public BaseResponse(@NotNull Integer status, String errorCode, String userMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.userMessage = userMessage;
    }

}
