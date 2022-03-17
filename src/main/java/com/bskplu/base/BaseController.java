package com.bskplu.base;

import com.bskplu.auth.BaiDuAuth;
import com.bskplu.model.dto.BaiDuAuthOut;
import com.bskplu.util.auth.AuthContainer;
import com.bskplu.util.consts.AiConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Controller 公共父类
 * Created by 尘心 on 2020/9/19 0019.
 */
@Slf4j
@Component
public abstract class BaseController {

    @Autowired
    private BaiDuAuth baiDuAuth;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取访问令牌
     */
    public String getAccessToken() {
        // 缓存中有,则直接获取
        if (redisTemplate.hasKey(AiConstant.TOKEN_KEY)) {
            log.info("从缓存当中获取access token");  
            return (String) redisTemplate.opsForValue().get(AiConstant.TOKEN_KEY);
        }

        // 容器当中已经有了, 则直接从容器当中获取
        if (AuthContainer.isContains(AiConstant.TOKEN_KEY)) {
            return AuthContainer.getAuthToken(AiConstant.TOKEN_KEY);
        }
        // 容器当中没有, 则去获取访问令牌
        BaiDuAuthOut out = baiDuAuth.getAccessToken();
        if (out!=null) {
            return out.getAccess_token();
        }

        return null;
    }
}
