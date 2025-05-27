package com.cloud.bluewhale.mq;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cloud.bluewhale.video.pojo.Video;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 视频消息队列
 * @author shigc
 */
@Log4j2
@Component
public class VideoPublishListener{

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "search.video.queue", durable = "true"),
            exchange = @Exchange(value = "search.exchange", durable = "true"),
            key = "search.video")
    )
    public void onMessage(Video video) {
        if (StringUtils.isBlank(video.getTitle())) {
            return;
        }
        log.info("ES接收到视频发布消息:{}", video);
        try {
            // 指定索引名
            IndexRequest indexRequest = new IndexRequest("tb_video");
            // 指定文档id
            indexRequest.id(video.getId().toString());
            // 指定文档内容
            indexRequest.source(JSON.toJSONString(video), XContentType.JSON);
            // 执行索引请求
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                log.info("视频文档创建成功，索引名：{}，文档id：{}", indexResponse.getIndex(), indexResponse.getId());
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("视频文档更新成功，索引名：{}，文档id：{}", indexResponse.getIndex(), indexResponse.getId());
            }
        } catch (IOException e) {
            log.error("索引文档失败，索引名：{}，文档id：{}", "tb_video", video.getId(), e);
        }

    }
}
