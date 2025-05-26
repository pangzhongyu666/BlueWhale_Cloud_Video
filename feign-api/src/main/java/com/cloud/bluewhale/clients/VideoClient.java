package com.cloud.bluewhale.clients;


import com.cloud.bluewhale.interceptor.MyFeignRequestInterceptor;
import com.cloud.bluewhale.response.ResponseResult;
import com.cloud.bluewhale.video.vo.VideoDetail;
import com.cloud.bluewhale.video.vo.VideoInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 视频客户端
 * @author shigc
 */
@FeignClient(value = "service-video", configuration = MyFeignRequestInterceptor.class)
public interface VideoClient {

    /**
     * 得到用户被赞数
     * @param userId 用户id
     * @return 被赞数
     */
    @GetMapping("/api/video/getUserLikes")
    ResponseResult<Integer> getUserLikes(@RequestParam("userId") Long userId);

    /**
     * 得到用户作品总数
     * @param userId 用户id
     * @return 作品总数
     */
    @GetMapping("/api/video/getUserWorks")
    ResponseResult<Integer> getUserWorks(@RequestParam("userId")Long userId);

    /**
     * 得到视频简略信息
     * @param videoId 视频id
     * @return 视频简略信息
     */
    @GetMapping("/api/video/info")
    ResponseResult<VideoInfo> getVideoInfo(@RequestParam("videoId") Long videoId);

    /**
     * 得到视频详细信息
     * @param videoId 视频id
     * @return 视频详细信息
     */
    @GetMapping("/api/video/detailInfo")
    ResponseResult<VideoDetail> getVideoDetailInfo(@RequestParam("videoId") Long videoId);
}
