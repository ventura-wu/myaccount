package com.wch.account.dao.jpa;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author c
 * @date 2021/4/1
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
public class UserPO  extends BasePO{

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;
}
