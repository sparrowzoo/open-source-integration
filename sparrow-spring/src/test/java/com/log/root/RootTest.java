package com.log.root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisCluster;

/**
 * created by harry on 2016/3/16.
 */
public class RootTest {
    private static Logger logger = LoggerFactory.getLogger(RootTest.class);

    public static void main(String[] args) {
        logger.info("root info");
        //JedisCluster jedisCluster=new JedisCluster();
        //jedisCluster.get();
    }
}
