package com.cloud.bluewhale.clients;

import com.cloud.bluewhale.interceptor.MyFeignRequestInterceptor;
import com.cloud.bluewhale.response.ResponseResult;
import com.cloud.bluewhale.user.vo.UserPersonalInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户服务客户端接口
 * @author shigc
 */
@FeignClient(value = "service-user", configuration = MyFeignRequestInterceptor.class)
public interface UserClient {

    /**
     * 获取用户个人信息
     * @param userId 用户id
     * @return ResponseResult
     */
    @GetMapping("/api/user/personal")
    ResponseResult<UserPersonalInfoVo> getUserPersonalInfo(@RequestParam("userId") Long userId);
}
