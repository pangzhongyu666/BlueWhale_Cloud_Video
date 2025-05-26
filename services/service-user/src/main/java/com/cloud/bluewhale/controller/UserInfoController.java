package com.cloud.bluewhale.controller;

import com.cloud.bluewhale.response.ResponseResult;
import com.cloud.bluewhale.service.UserInfoService;
import com.cloud.bluewhale.user.dto.AckPasswordDto;
import com.cloud.bluewhale.user.dto.UserPersonInfoDto;
import com.cloud.bluewhale.user.vo.UserHomePageVo;
import com.cloud.bluewhale.user.vo.UserPersonalInfoVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 用户信息控制器
 * @author shigc
 */
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 获取用户个人信息
     * @param userId 用户id
     * @return ResponseResult<UserPersonalInfoVo> 用户个人信息
     */
    @GetMapping("/personal")
    public ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(@RequestParam(value = "userId", required = false) Long userId){
        return userInfoService.getUserPersonalInfo(userId);
    }

    /**
     * 上传用户头像
     * @param imageFile 用户头像文件
     * @return ResponseResult<String> 图片地址
     */
    @PostMapping("/image/upload")
    public ResponseResult<String> uploadUserImage(MultipartFile imageFile){
        return userInfoService.uploadUserImage(imageFile);
    }

    /**
     * 更新用户个人信息
     * @param userPersonInfo 用户个人信息
     * @return ResponseResult 更新结果
     */
    @PutMapping("/personal")
    public ResponseResult updateUserPersonalInfo(UserPersonInfoDto userPersonInfo){
        return userInfoService.updateUserPersonalInfo(userPersonInfo);
    }

    /**
     * 获取用户主页信息
     * @param userId 用户id
     * @return ResponseResult<UserHomePageVo> 用户主页信息
     */
    @GetMapping("/homePage")
    public ResponseResult<UserHomePageVo> getUserHomePage(Long userId){
        return userInfoService.getUserHomePage(userId);
    }

    /**
     * 校验密码
     * @param ackPasswordDto 密码
     * @return ResponseResult<Boolean> 校验结果
     */
    @GetMapping("/ackPassword")
    public ResponseResult<Boolean> ackPassword(AckPasswordDto ackPasswordDto){
        return userInfoService.ackPassword(ackPasswordDto);
    }
}
