package org.muzhe.test.muzheCache.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;

import java.util.List;
import java.util.Set;

/**
 * @author muzhe-wang on  18-8-15 下午2:06.
 */
public class RedisCache implements Cache {

    private final static String REDIS_KEY_PREFIX = "muzhe:test";

    protected JedisCommands getRedisClient() {
        return new Jedis("127.0.0.1", 6379);
    }

    public String get(String key) {

        return getRedisClient().get(withPrefixKey(key));
    }

    public void set(String key, String value) {
        getRedisClient().set(withPrefixKey(key), value);
    }

    public void setEx(String key, String value, int expireSeconds) {

        getRedisClient().setex(withPrefixKey(key), expireSeconds, value);
    }

    public String hGet(String key, String field) {
        return getRedisClient().hget(withPrefixKey(key), field);
    }

    public Long hSet(String key, String field, String value) {
        return getRedisClient().hset(withPrefixKey(key), field, value);
    }

    public void hDel(String key, String field) {
        getRedisClient().hdel(withPrefixKey(key), field);
    }

    public boolean exists(String key) {
        return getRedisClient().exists(withPrefixKey(key));
    }

    public long decr(String key) {
        return getRedisClient().decr(withPrefixKey(key));
    }

    public long incr(String key) {
        return getRedisClient().incr(withPrefixKey(key));
    }

    public long expire(String key, int second) {
        return getRedisClient().expire(withPrefixKey(key), second);
    }

    public List<String> lRange(String key, long start, long stop) {
        return getRedisClient().lrange(withPrefixKey(key), start, stop);
    }

    public void lTrim(String key, long start, long stop) {
        getRedisClient().ltrim(withPrefixKey(key), start, stop);
    }

    public void lPush(String key, String value) {
        getRedisClient().lpush(withPrefixKey(key), value);
    }

    public void del(String key) {
        getRedisClient().del(withPrefixKey(key));
    }

    public long lLen(String key) {
        return getRedisClient().llen(withPrefixKey(key));
    }

    public String lIndex(String key, long index) {
        return getRedisClient().lindex(withPrefixKey(key), index);
    }

    public String lPop(String key) {
        return getRedisClient().lpop(withPrefixKey(key));
    }

    public long incrAndExpire(String key, int second) {
        Long result = getRedisClient().incr(withPrefixKey(key));
        getRedisClient().expire(withPrefixKey(key), second);
        return result;
    }

    public void sAdd(String key, String member) {
        getRedisClient().sadd(withPrefixKey(key), member);
    }

    public boolean sisMember(String key, String member) {
        return getRedisClient().sismember(withPrefixKey(key), member);
    }

    public Set<String> hKeys(String key) {
        return getRedisClient().hkeys(withPrefixKey(key));
    }

    public String withPrefixKey(String key) {
        return REDIS_KEY_PREFIX + key;
    }
}
