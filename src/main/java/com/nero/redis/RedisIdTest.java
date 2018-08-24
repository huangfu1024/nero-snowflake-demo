package com.nero.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 基于redis的分布式ID生成方案
 * <p>
 * date : 2018/8/24
 * time : 下午3:57
 * </p>
 *
 * @author Nero
 */
@Component
public class RedisIdTest implements CommandLineRunner {

    @Autowired
    private RedisIdWorker redisIdWorker;

    @Override
    public void run(String... args) {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(redisIdWorker.nextId());
        }
        System.out.println(System.currentTimeMillis() - t1);
    }
}
