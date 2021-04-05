package com.wch.account.service.impl;

import com.google.common.collect.Lists;
import com.wch.account.common.PaginationParam;
import com.wch.account.domo.UserDO;
import com.wch.account.dao.UserRepository;
import com.wch.account.dao.jpa.UserPO;
import com.wch.account.enums.DeletedEnum;
import com.wch.account.enums.errorenums.BasicErrorCode;
import com.wch.account.exception.BusinessErrorException;
import com.wch.account.mapper.ModelMapper;
import com.wch.account.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    public List<UserDO> findUserList(String keyword, PaginationParam paginationParam) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(paginationParam.getPage() - 1, paginationParam.getPageSize(), sort);

        // Page<UserPO> userPOPage = userRepository.findAll(new Specification<UserPO>() {
        //     @Override
        //     public Predicate toPredicate(Root<UserPO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        //         return null;
        //     }
        // },pageable);
        Page<UserPO> userPOPage = userRepository.findAll((root, query, cb) -> {
            List<Predicate> predicateList = Lists.newArrayList();

            if (StringUtils.isNotBlank(keyword)) {
                Predicate p1 = cb.like(root.get("userName"), "%" + keyword + "%");
                predicateList.add(p1);
            }
            Predicate p2 = cb.equal(root.get("deleted"), DeletedEnum.NORMAL.getType());
            predicateList.add(p2);

            return cb.and(predicateList.toArray(new Predicate[0]));
        }, pageable);

        paginationParam.setTotalCount(userPOPage.getTotalElements());

        return modelMapper.mapList(userPOPage.toList(), UserDO.class);
    }

    @Override
    public UserDO findUserPOById(Long userId) {
        UserPO userPo = userRepository.findByIdAndDeleted(userId, DeletedEnum.NORMAL.getType())
                .orElseThrow(() -> new BusinessErrorException(BasicErrorCode.RESOURCE_NOT_EXIST.getErrorCode()));
        return modelMapper.map(userPo, UserDO.class);
    }
}
