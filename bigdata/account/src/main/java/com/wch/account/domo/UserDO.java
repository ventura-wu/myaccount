package com.wch.account.domo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author c
 * @date 2021/4/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDO extends BaseDO{

    private String userName;

    private String passWord;

    private Integer sex;

    private Date birthday;

    private String phone;

}
