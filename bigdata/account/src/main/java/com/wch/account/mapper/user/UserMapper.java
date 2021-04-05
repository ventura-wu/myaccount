package com.wch.account.mapper.user;

import com.wch.account.dao.jpa.UserPO;
import com.wch.account.domo.UserDO;
import com.wch.account.mapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author c
 * @date 2021/4/5
 */
@Component
@Slf4j
public class UserMapper extends ModelMapper {
    @PostConstruct
    void init() {
        userPOToUserDO();
        userDOToUserPO();
    }

    private void userPOToUserDO() {
        mapperFactory.classMap(UserPO.class, UserDO.class)
                .customize(new CustomMapper<UserPO, UserDO>() {
                    @Override
                    public void mapAtoB(UserPO userPO, UserDO userDO, MappingContext context) {
                        userDO.setSex(userPO.getSex() == 1 ? "男" : "女");
                    }
                })
                .byDefault()
                .register();
    }

    private void userDOToUserPO() {
        mapperFactory.classMap(UserDO.class, UserPO.class)
                .customize(new CustomMapper<UserDO, UserPO>() {
                    @Override
                    public void mapAtoB(UserDO userDO, UserPO userPO, MappingContext context) {
                        if("男".equals(userDO.getSex())) {
                            userPO.setSex(1);
                        }else if("女".equals(userDO.getSex())){
                            userPO.setSex(2);
                        }else {
                            userPO.setSex(0);
                        }
                    }
                })
                .byDefault()
                .register();
    }
}
