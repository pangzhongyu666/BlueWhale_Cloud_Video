package com.cloud.bluewhale.mq;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cloud.bluewhale.user.pojo.User;
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
 * 用户信息监听器
 * 用于更新用户信息到es中
 */
@Log4j2
@Component
public class UserInfoListener{

    @Resource
    private RestHighLevelClient restHighLevelClient;


    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "search.user.queue", durable = "true"),
        exchange = @Exchange(value = "search.exchange", durable = "true"),
        key = "search.user")
    )
    public void onMessage(User user) {
        if (StringUtils.isBlank(user.getUsername())) {
            return;
        }
        log.info("ES接收到用户信息变化消息:{}", user);
        try {
            // 指定索引名
            IndexRequest indexRequest = new IndexRequest("tb_user");
            // 指定文档id
            indexRequest.id(user.getId().toString());
            // 指定文档内容
            indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
            // 执行索引请求
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                log.info("用户信息文档创建成功，索引名：{}，文档id：{}", indexResponse.getIndex(), indexResponse.getId());
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                log.info("用户信息文档更新成功，索引名：{}，文档id：{}", indexResponse.getIndex(), indexResponse.getId());
            }
        } catch (IOException e) {
            log.error("索引文档失败，索引名：{}，文档id：{}", "tb_video", user.getId(), e);
        }
    }
}
