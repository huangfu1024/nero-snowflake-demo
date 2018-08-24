package com.nero.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 基于redis的分布式ID生成方案
 * <p>
 * date : 2018/8/24
 * time : 下午3:33
 * </p>
 *
 * @author Nero
 */
@Component
public class RedisIdWorker {

    private StringRedisTemplate template;

    @Autowired
    public RedisIdWorker(StringRedisTemplate template) {
        this.template = template;
    }

    public Long nextId(){

        return nextIdBy(1L);

    }

    public Long nextIdBy(Long v){

        // insert String
        ValueOperations<String, String> valueOps = this.template.opsForValue();
        return valueOps.increment("id_k", v);
    }

}
