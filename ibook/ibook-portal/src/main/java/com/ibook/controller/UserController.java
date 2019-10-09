package com.ibook.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ibook.api.user.IUserService;
import com.ibook.api.user.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Reference(version = "1.0.0")
    private IUserService userService;


    @GetMapping("/user")
    public ResponseEntity<UserDTO> login(String loginInfo, HttpServletResponse httpRsp) {
        // 登录鉴权
        UserDTO login = userService.login(loginInfo);
        return new ResponseEntity<>(login, HttpStatus.OK);

    }

    @GetMapping("/register")
    public ResponseEntity<String> register(String regInfo, HttpServletResponse httpRsp) {
        // 登录鉴权
        String id = userService.register(regInfo);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}