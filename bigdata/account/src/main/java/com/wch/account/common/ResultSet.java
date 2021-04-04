package com.wch.account.common;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author c
 * @date 2021/4/4
 */
@Data
public class ResultSet<T> {
    @NonNull
    private PaginationParam paginationParam;
    @NonNull
    private List<T> result;

    public ResultSet() {
    }

    public ResultSet(@NonNull PaginationParam paginationParam, @NonNull List<T> result) {
        this.paginationParam = paginationParam;
        this.result = result;
    }
}
