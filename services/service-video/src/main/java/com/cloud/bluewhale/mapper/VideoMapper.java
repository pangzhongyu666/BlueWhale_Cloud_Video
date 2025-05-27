package com.cloud.bluewhale.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.bluewhale.video.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface VideoMapper extends BaseMapper<Video> {

    /**
     * 获取最新的视频
     * @return 视频
     */
    @Select("select * from tb_video order by id desc limit 1")
    Video getLastVideo();
}
