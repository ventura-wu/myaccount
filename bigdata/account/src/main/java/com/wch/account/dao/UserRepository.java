package com.wch.account.dao;

import com.wch.account.dao.jpa.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author c
 * @date 2021/4/1
 */
public interface UserRepository extends JpaSpecificationExecutor<UserPO>, JpaRepository<UserPO, Integer> {

    /**
     * find user by userId and deleted
     *
     * @param userId
     * @param deleted
     * @return
     */
    Optional<UserPO> findByIdAndDeleted(Long userId, Integer deleted);

    /**
     * find user by userName and deleted
     *
     * @param userName
     * @param deleted
     * @return
     */
    Optional<UserPO> findByUserNameAndDeleted(String userName, Integer deleted);

    /**
     * find user by userName
     * @param userName
     * @return
     */
    Optional<UserPO>findByUserName(String userName);
    /**
     * find all user by deleted
     *
     * @param deleted
     * @return
     */
    List<UserPO> findAllByDeleted(Integer deleted);
}
