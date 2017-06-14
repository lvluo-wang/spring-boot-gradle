package com.yx.statistics.dao;

/**
 * Created by zhang on 2017/2/23.
 */
public interface RedisTestDao {

    String pre_key="zhang";

    void insert(String json);


    String get(String key);

}
