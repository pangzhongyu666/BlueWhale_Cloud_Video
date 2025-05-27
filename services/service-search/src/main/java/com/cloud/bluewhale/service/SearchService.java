package com.cloud.bluewhale.service;

import com.cloud.bluewhale.interact.vo.UserListVo;
import com.cloud.bluewhale.interact.vo.VideoListVo;
import com.cloud.bluewhale.response.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * 搜索模块接口类
 * @author shigc
 */
@Service
public interface SearchService {
    /**
     * 搜索用户
     * @param keyword 关键字
     * @param page 页码
     * @param pageSize 页大小
     * @return 用户列表
     */
    ResponseResult<UserListVo> searchUser(String keyword, Integer page, Integer pageSize);

    /**
     * 搜索视频
     * @param keyword 关键字
     * @param page 页码
     * @param pageSize 页大小
     * @return 视频列表
     */
    ResponseResult<VideoListVo> searchVideo(String keyword, Integer page, Integer pageSize);
}
