package com.wch.account.common;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;

/**
 * @author c
 * @date 2021/4/4
 */
@Data
public class PaginationParam {
    @NonNull
    private Integer page;
    @Min(
            value = 1L,
            message = "每页最小值1"
    )
    @NonNull
    private Integer pageSize;
    @NonNull
    private Long totalCount;

    public PaginationParam(@NonNull Integer page, @NonNull Integer pageSize, @NonNull Long totalCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public PaginationParam() {
    }
}
