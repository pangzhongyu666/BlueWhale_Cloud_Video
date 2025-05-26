package com.cloud.bluewhale.interact.vo;

import com.cloud.bluewhale.video.vo.VideoDetail;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 视频列表Vo类
 * @author shigc
 */
@Data
@Builder
public class VideoListVo {

    /**
     *  本次总数
     */
    private Integer total;

    /**
     *  视频列表
     */
    private List<VideoDetail> videoList;
}
