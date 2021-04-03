package com.wch.account.mapper;

import com.wch.account.dao.jpa.UserPO;
import com.wch.account.domo.UserDO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author c
 * @date 2021/4/3
 */
public class ModelMapper {
    protected final MapperFactory mapperFactory;

    public ModelMapper() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public <T> T map(Object obj, Class<T> targetTye) {
        return mapperFactory.getMapperFacade().map(obj, targetTye);
    }

    public <T> T map(Object obj, Class<T> targetTye, MappingContext context) {
        return mapperFactory.getMapperFacade().map(obj, targetTye, context);
    }

    public <T> List<T> mapList(List<?> source, Class<T> targetTye) {
        return mapperFactory.getMapperFacade().mapAsList(source, targetTye);
    }

    public <T> List<T> mapList(List<?> source, Class<T> targetTye, MappingContext context) {
        return mapperFactory.getMapperFacade().mapAsList(source, targetTye, context);
    }

    @PostConstruct
    void init() {
        userPOToUserDO();
    }
    private void userPOToUserDO(){
        mapperFactory.classMap(UserPO.class, UserDO.class)
                .customize(new CustomMapper<UserPO, UserDO>() {
                    @Override
                    public void mapAtoB(UserPO userPO, UserDO userDO, MappingContext context) {
                        userDO.setUserId(userPO.getId());
                        userDO.setSex(userPO.getSex()==1?"男":"女");
                    }
                })
                .byDefault()
                .register();
    }
}
