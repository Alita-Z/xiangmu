package com.example.hardcoredemo.common.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RedissonConfig {

    @Value("${redisson.redisAddress}")
    private String redisAddress;

//    @Bean
    public RedissonClient redisson(){
        //1、创建配置
        Config config = new Config();
        config.useSingleServer().setAddress(redisAddress);
//        config.useClusterServers().addNodeAddress(redisAddress);
        //2、根据Config创建出RedissonClient实例
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
