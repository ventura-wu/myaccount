package com.wch.account.dao;

import com.wch.account.dao.jpa.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author c
 * @date 2021/4/1
 */
public interface UserRepository extends JpaRepository<UserPO,Integer> {

    /**
     * find user by userId
     * @param userId
     * @return
     */
    Optional<UserPO> findById(Long userId);
}
