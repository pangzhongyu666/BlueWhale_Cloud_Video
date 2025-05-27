package com.cloud.bluewhale.controller;

import com.cloud.bluewhale.interact.vo.UserListVo;
import com.cloud.bluewhale.interact.vo.VideoListVo;
import com.cloud.bluewhale.response.ResponseResult;
import com.cloud.bluewhale.service.SearchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 搜索模块
 * @author shigc
 */
@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    /**
     * 搜索用户
     * @param keyword 关键字
     * @param page 页码
     * @param pageSize 页大小
     * @return 用户列表
     */
    @GetMapping("/user")
    public ResponseResult<UserListVo> searchUser(String keyword, Integer page, Integer pageSize) {
        return searchService.searchUser(keyword, page, pageSize);
    }

    /**
     * 搜索视频
     * @param keyword 关键字
     * @param page 页码
     * @param pageSize 页大小
     * @return 视频列表
     */
    @GetMapping("/video")
    public ResponseResult<VideoListVo> searchVideo(String keyword, Integer page, Integer pageSize) {
        return searchService.searchVideo(keyword, page, pageSize);
    }
}
