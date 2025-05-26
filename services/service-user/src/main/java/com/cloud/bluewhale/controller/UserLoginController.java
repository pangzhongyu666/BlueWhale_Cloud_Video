package com.cloud.bluewhale.controller;

import com.cloud.bluewhale.response.ResponseResult;
import com.cloud.bluewhale.service.UserLoginService;
import com.cloud.bluewhale.user.dto.RegisterDto;
import com.cloud.bluewhale.user.dto.UserLoginDto;
import com.cloud.bluewhale.user.vo.UserLoginVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户登录控制器
 * @author shigc
 */
@RestController
@RequestMapping("/api/user/login")
public class UserLoginController {

    @Resource
    private UserLoginService userLoginService;
    /**
     * 用户注册
     * @param registerDto 注册信息
     * @return 登录结果
     */
    @PostMapping("/register")
    public ResponseResult register(RegisterDto registerDto) {
        return userLoginService.register(registerDto);
    }

    /**
     * 用户登录
     * @param userLoginDto 登录信息
     * @return 登录结果
     */
    @PostMapping
    public ResponseResult<UserLoginVo> userLogin(UserLoginDto userLoginDto) {
        return userLoginService.userLogin(userLoginDto);
    }
}
