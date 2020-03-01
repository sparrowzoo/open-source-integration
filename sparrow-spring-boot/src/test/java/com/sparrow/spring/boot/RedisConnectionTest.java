package com.sparrow.spring.boot;

import com.sparrow.spring.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RedisConnectionTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test() throws IOException {
        List<RedisClientInfo> redisClientInfos = redisTemplate.getClientList();
        List<RedisConnection> redisConnections = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        redisTemplate.opsForValue().get("a" + System.currentTimeMillis());
                    }
                }
            }).start();
        }
        System.in.read();
    }
}
