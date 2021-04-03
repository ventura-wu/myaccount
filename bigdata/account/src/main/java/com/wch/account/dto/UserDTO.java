package com.wch.account.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author c
 * @date 2021/4/1
 */
@Data
public class UserDTO {
    private Long userId;

    private String userName;

    private String passWord;

    private String sex;

    private Date birthday;

    private String phone;

    private String createUser;

    private Long createTime;

    private String lastModifyUser;

    private Long lastModifyTime;
}
