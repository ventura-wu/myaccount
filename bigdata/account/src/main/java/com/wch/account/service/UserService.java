package com.wch.account.service;

import com.wch.account.domo.UserDO;

import java.util.List;

/**
 * @author c
 * @date 2021/4/1
 */
public interface UserService {
    /**
     * query user by userid
     *
     * @param userId userid
     * @return userpo
     */
    UserDO findUserPoById(Long userId);

    /**
     * find all user
     * @return
     */
    List<UserDO> findAll();
}