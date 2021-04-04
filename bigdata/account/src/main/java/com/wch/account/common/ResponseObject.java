package com.wch.account.common;

import lombok.Data;

/**
 * @author c
 * @date 2021/4/4
 */
@Data
public class ResponseObject<T>extends BaseResponse {
    private T data;

    public ResponseObject(T data) {
        super(200);
        this.data = data;
    }

    public ResponseObject() {
    }


}
