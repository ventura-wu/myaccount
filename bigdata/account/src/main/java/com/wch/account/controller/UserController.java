package com.wch.account.controller;

import com.wch.account.common.PaginationParam;
import com.wch.account.common.ResponseList;
import com.wch.account.common.ResponseObject;
import com.wch.account.common.ResultSet;
import com.wch.account.domo.UserDO;
import com.wch.account.dto.UserDTO;
import com.wch.account.mapper.ModelMapper;
import com.wch.account.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "根据ID获取User信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    public ResponseEntity<ResponseObject<UserDTO>> getUser(@PathVariable("userId") Long userId) {
        UserDTO userDTO = modelMapper.map(userService.findUserPOById(userId), UserDTO.class);
        return ResponseEntity.ok(new ResponseObject<>(userDTO));
    }

    @GetMapping
    @ApiOperation(value = "获取所有的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "查询关键字-(用户名称)", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", dataType = "Integer", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页码大小", dataType = "Integer", paramType = "query", defaultValue = "1000"),
    })
    public ResponseList<UserDTO> getUserList(@RequestParam(required = false) String keyword,
                                             PaginationParam paginationParam) {
        List<UserDTO> userDTOList = modelMapper.mapList(userService.findUserList(keyword, paginationParam), UserDTO.class);
        return new ResponseList<>(new ResultSet<>(paginationParam, userDTOList));
    }

    @PostMapping(value = "/insert")
    @ApiOperation(value = "新增User信息")
    public ResponseEntity<ResponseObject<UserDTO>> insertUser(@RequestBody UserDTO userDTO) {
        userDTO = modelMapper.map(userService.saveUser(modelMapper.map(userDTO, UserDO.class)), UserDTO.class);
        return ResponseEntity.ok(new ResponseObject<>(userDTO));
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改User信息")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return null;
    }

    @DeleteMapping(value = "/deleted/{userId}")
    @ApiOperation(value = "根据ID删除User信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    public UserDTO deletedUser(@PathVariable("userId") Integer userId) {
        return null;
    }
}
