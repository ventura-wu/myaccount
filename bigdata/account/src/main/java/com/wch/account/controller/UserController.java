package com.wch.account.controller;

import com.wch.account.dto.UserDTO;
import com.wch.account.mapper.ModelMapper;
import com.wch.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author c
 * @date 2021/4/1
 */
@RestController
@RequestMapping(path = {"/account/user"})
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{userId}")
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return modelMapper.map(userService.findUserPoById(userId), UserDTO.class);
    }

    @GetMapping
    public List<UserDTO> getUserList() {
        return modelMapper.mapList(userService.findAll(), UserDTO.class);
    }
    @PostMapping
    public UserDTO insertUser(){
        return null;
    }
}
