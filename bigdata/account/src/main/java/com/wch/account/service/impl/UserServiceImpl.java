package com.wch.account.service.impl;

import com.wch.account.domo.UserDO;
import com.wch.account.dao.UserRepository;
import com.wch.account.dao.jpa.UserPO;
import com.wch.account.enums.errorenums.BasicErrorCode;
import com.wch.account.exception.BusinessErrorException;
import com.wch.account.mapper.ModelMapper;
import com.wch.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author c
 * @date 2021/4/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDO findUserPoById(Long userId) {
        UserPO userPo = userRepository.findById(userId).orElseThrow(()->new BusinessErrorException(BasicErrorCode.RESOURCE_NOT_EXIST.getErrorCode()));
        return modelMapper.map(userPo, UserDO.class);
    }

    @Override
    public List<UserDO> findAll() {
        List<UserPO> userPoList = userRepository.findAll();

        return modelMapper.mapList(userPoList, UserDO.class);
    }
}
