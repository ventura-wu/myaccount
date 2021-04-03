package com.wch.account.dao;

import com.wch.account.dao.jpa.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author c
 * @date 2021/4/1
 */
public interface UserRepository extends JpaRepository<UserPO,Integer> {

    /**
     * find user by userId and deleted
     * @param userId
     * @param deleted
     * @return
     */
    Optional<UserPO> findByIdAndDeleted(Long userId,Integer deleted);

    /**
     * find all user by deleted
     * @param deleted
     * @return
     */
    List<UserPO> findAllByDeleted(Integer deleted);
}
