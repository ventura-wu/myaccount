package com.wch.account.domo;

import lombok.Data;

import java.util.Date;

/**
 * @author c
 * @date 2021/4/5
 */
@Data
public class BaseDO {
    private Long id;

    private Integer deleted;

    private String createUser;

    private Date createTime;

    private String lastModifyUser;

    private Date lastModifyTime;
}
