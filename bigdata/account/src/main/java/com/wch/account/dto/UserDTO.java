package com.wch.account.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author c
 * @date 2021/4/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "删除标记:0未删除;1删除")
    private Integer deleted;

    @ApiModelProperty(value = "名称")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String passWord;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "创建者")
    private String createUser;

    @ApiModelProperty(value = "创建日期")
    private Long createTime;

    @ApiModelProperty(value = "最后修改用户")
    private String lastModifyUser;

    @ApiModelProperty(value = "最后修改时间")
    private Long lastModifyTime;
}
