package com.cloud.bluewhale.interceptor;

import com.cloud.bluewhale.utils.ThreadLocalUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @desciption feign请求全局添加Token
 * @className MyFeignRequestInterceptor
 */
@Configuration
public class MyFeignRequestInterceptor  implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("userId", ThreadLocalUtil.getUserId().toString());
    }
}
