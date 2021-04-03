package com.wch.account.dao.jpa;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author c
 * @date 2021/4/3
 */
@MappedSuperclass
@Data
public abstract class BasePO implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "deleted",nullable = false)
    private Integer deleted;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "last_modify_user")
    private String lastModifyUser;

    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;

    @UpdateTimestamp
    @Column(name = "last_modify_time")
    private Date lastModifyTime;
}
