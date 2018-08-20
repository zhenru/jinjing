package org.muzhe.test.cache;

import org.junit.Assert;
import org.junit.Test;
import org.muzhe.test.muzheCache.cache.RedisCache;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author muzhe-wang on  18-8-16 下午3:13.
 */
public class RedisCacheTest {

    private RedisCache redisCache = new RedisCache();

    private static String KEY = "name";

    private static String VALUE = "往五";

    private static String EXPIRE_KEY = "expire_name";

    private static String EXPIRE_VALUE = "expire_value";

    private static int DEFAULT_EXPIRE_TIME = 2;

    private static String H_KEY = "h_name";

    private static String H_VALUE = "h_value";

    private static String H_FIELD = "h_field";

    private static String H_FIELD_1 = "h_field_1";

    private static String NUM_KEY = "NUM";

    private static int DEFAULT_NUM = 1;

    private static String LIST_KEY = "LIST_KEY";

    private static String LIST_VALUE = "LIST_VALUE";

    private static String LIST_VALUE_1 = "LIST_VALUE_1";

    private static String LIST_VALUE_2 = "LIST_VALUE_2";

    private static String LIST_VALUE_3 = "LIST_VALUE_3";

    private static String LIST_VALUE_4 = "LIST_VALUE_4";

    private static String DELETE_KEY = "DELETE_KEY";

    private static String DELETE_VALUE = "DELETE_VALUE";

    private static String SET_KEY = "SET_KEY";

    private static String SET_MEM_1 = "SET_MEM1";

    private static String SET_MEM_2 = "SET_MEM2";

    private static String SET_MEM_3 = "SET_MEM3";


    @Test
    public void get() {
        String name = redisCache.get(KEY);
        Assert.assertEquals(name, VALUE);
    }

    @Test
    public void set() {

        redisCache.set(KEY, VALUE);
    }

    @Test
    public void setEx() throws InterruptedException {
        redisCache.setEx(EXPIRE_KEY, EXPIRE_VALUE, DEFAULT_EXPIRE_TIME);
        TimeUnit.SECONDS.sleep(3);
        String expireResult = redisCache.get(EXPIRE_KEY);
        Assert.assertNull(expireResult);
    }

    @Test
    public void hGet() {

        String hResult = redisCache.hGet(H_KEY, H_FIELD);
        Assert.assertEquals(hResult, H_VALUE);
    }

    @Test
    public void hSet() {

        Long hSetSuccessCount = redisCache.hSet(H_KEY, H_FIELD, H_VALUE);
        System.out.println(hSetSuccessCount);
    }

    @Test
    public void hDel() {

        redisCache.hDel(H_KEY, H_FIELD);
    }

    @Test
    public void exists() {
        boolean exists = redisCache.exists(KEY);
        Assert.assertTrue(exists);
    }

    @Test
    public void decr() {

        redisCache.set(NUM_KEY, String.valueOf(DEFAULT_NUM));
        long decrResult = redisCache.decr(NUM_KEY);
        Assert.assertEquals(decrResult, DEFAULT_NUM - 1);

    }

    @Test
    public void incr() {

        long incrResult = redisCache.incr(NUM_KEY);
        Assert.assertEquals(incrResult, DEFAULT_NUM);
    }

    @Test
    public void expire() throws InterruptedException {

        redisCache.set(EXPIRE_KEY, EXPIRE_VALUE);
        redisCache.expire(EXPIRE_KEY, 1);
        TimeUnit.SECONDS.sleep(2);
        Assert.assertFalse(redisCache.exists(EXPIRE_KEY));

    }

    @Test
    public void lRange() {

        List<String> strings = redisCache.lRange(LIST_KEY, 0, 1);
        strings
                .stream()
                .forEach(value -> System.out.println(value));

    }

    @Test
    public void lTrim() {
    }

    @Test
    public void lPush() {

        redisCache.lPush(LIST_KEY, LIST_VALUE);
    }

    @Test
    public void lLen() {

        long valueCount = redisCache.lLen(LIST_KEY);
        Assert.assertEquals(valueCount, 1);
    }

    @Test
    public void lIndex() {
        redisCache.lPush(LIST_KEY, LIST_VALUE_1);
        redisCache.lPush(LIST_KEY, LIST_VALUE_2);
        redisCache.lPush(LIST_KEY, LIST_VALUE_3);
        redisCache.lPush(LIST_KEY, LIST_VALUE_4);
        String redis_result = redisCache.lIndex(LIST_KEY, 1);

        System.out.println(redis_result);


    }

    @Test
    public void lPop() {
        String s = redisCache.lPop(LIST_KEY);
        System.out.println(s);
    }

    @Test
    public void del() {

        redisCache.set(DELETE_KEY, DELETE_VALUE);
        redisCache.del(DELETE_KEY);

    }

    @Test
    public void incrAndExpire() {
    }

    @Test
    public void sAdd() {

        redisCache.sAdd(SET_KEY, SET_MEM_1);
        redisCache.sAdd(SET_KEY, SET_MEM_2);
        redisCache.sAdd(SET_KEY, SET_MEM_3);

    }

    @Test
    public void sisMember() {

        boolean sisMember = redisCache.sisMember(SET_KEY, SET_MEM_3);
        Assert.assertTrue(sisMember);
    }

    @Test
    public void hKeys() {

        redisCache.hSet(H_KEY, H_FIELD, H_VALUE);
        redisCache.hSet(H_KEY, H_FIELD_1, H_VALUE);

        Set<String> hKeys = redisCache.hKeys(H_KEY);
        hKeys.stream().forEach(key -> System.out.println(key));
        Assert.assertEquals(hKeys.size(), 2);

    }

    @Test
    public void withPrefixKey() {
    }
}