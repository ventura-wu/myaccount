package com.wch.account.service;

import com.wch.account.common.PaginationParam;
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
    UserDO findUserPOById(Long userId);

    /**
     * find all user
     * @param keyword
     * @param paginationParam
     * @return
     */
    List<UserDO> findUserList(String keyword, PaginationParam paginationParam);
}