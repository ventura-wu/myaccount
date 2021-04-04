package com.wch.account.common;

import lombok.Data;

/**
 * @author c
 * @date 2021/4/4
 */
@Data
public class ResponseList<T> extends BaseResponse {
    private ResultSet<T> data;

    public ResponseList() {
        super(200);
    }

    public ResponseList(ResultSet<T> data) {
        super(200);
        this.data = data;
    }
}
