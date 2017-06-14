package com.yx.statistics.dao.impl;

import com.yx.statistics.dao.RedisTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;


/**
 * Created by zhang on 2017/2/23.
 */
@Repository
public class RedisTestDaoImpl implements RedisTestDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate; //1

    @Override
    public void insert(String json){
        BoundValueOperations boundValueOps=stringRedisTemplate.boundValueOps(pre_key+"x");
        boundValueOps.set(json);
    }

    @Override
    public String get(String json){
       BoundValueOperations<String,String> boundValueOps=stringRedisTemplate.boundValueOps(pre_key+"x");
       return boundValueOps.get();
    }



}
