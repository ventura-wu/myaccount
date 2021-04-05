package com.wch.account.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author c
 * @date 2021/4/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseDTO {
    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "删除标记:0未删除;1删除")
    private Integer deleted;

    @ApiModelProperty(value = "创建者")
    private String createUser;

    @ApiModelProperty(value = "创建日期")
    private Date createTime;

    @ApiModelProperty(value = "最后修改用户")
    private String lastModifyUser;

    @ApiModelProperty(value = "最后修改时间")
    private Date lastModifyTime;
}
