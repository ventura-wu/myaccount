package com.wch.account.controller;

import com.wch.account.dto.UserDTO;
import com.wch.account.mapper.ModelMapper;
import com.wch.account.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


/**
 * @author c
 * @date 2021/4/1
 */
@RestController
@RequestMapping(path = {"/account/user"})
@EnableSwagger2
@Api(tags = {"用户信息-接口管理"})
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "根据ID获取USER的信息")
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true,dataType = "Long",paramType = "path")
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return modelMapper.map(userService.findUserPoById(userId), UserDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "获取所有的用户列表")
    public List<UserDTO> getUserList() {
        return modelMapper.mapList(userService.findAll(), UserDTO.class);
    }
    @PostMapping
    public UserDTO insertUser(){
        return null;
    }
}
