package org.muzhe.test.muzheCache.cache;

import java.util.List;
import java.util.Set;

/**
 * @author muzhe-wang on  18-8-15 上午11:13.
 */
public interface Cache {

    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置　cache的值
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 设置带过期时间的值
     * @param key
     * @param value
     * @param expireSeconds
     */
    void setEx(String key, String value, int expireSeconds);

    /**
     * 获取 key指向的map中的field对应的value
     * @param key
     * @param field
     * @return
     */
    String hGet(String key, String field);

    /**
     * 将　key　＝　filed value 添加到　key指向的map中
     * @param key
     * @param field
     * @param value
     * @return
     */
    Long hSet(String key, String field, String value);

    /**
     * 删除key指向的map中的field对应的value.
     * @param key
     * @param field
     */
    void hDel(String key, String field);

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    boolean exists(String key);

    /**
     * 对key对应的value减一
     * @param key
     * @return
     */
    long decr(String key);

    /**
     * 对　key对应的value加一
     * @param key
     * @return
     */
    long incr(String key);

    /**
     * 为key添加过期时间
     * @param key
     * @param second
     * @return
     */
    long expire(String key, int second);

    /**
     * 获取到key指向的list中区间
     * @param key
     * @param start
     * @param stop
     * @return
     */
    List<String> lRange(String key, long start, long stop);

    /**
     * 裁剪　key指向的list
     * @param key
     * @param start
     * @param stop
     */
    void lTrim(String key, long start, long stop);

    /**
     * 将value添加到　key对应的　list中去
     * @param key
     * @param value
     */
    void lPush(String key, String value);

    /**
     * 删除　key
     * @param key
     */
    void del(String key);

    /**
     *
     * @param key
     * @return
     */
    long lLen(String key);

    /**
     * 获取key对应的list中index对应的元素
     * @param key
     * @param index
     * @return
     */
    String lIndex(String key, long index);

    /**
     * 从key中弹出元素
     * @param key
     * @return
     */
    String lPop(String key);

    /**
     * 将key对应的元素增加１
     * 并设置过期时间
     * @param key
     * @param second
     * @return
     */
    long incrAndExpire(String key, int second);

    /**
     * 向　key对应的set中添加一个member元素
     * @param key
     * @param member
     */
    void sAdd(String key, String member);

    /**
     * 判断member是否在key对应的set中。
     * @param key
     * @param member
     * @return
     */
    boolean sisMember(String key, String member);

    /**
     * 获取key对应map的key的序列
     * @param key
     * @return
     */
    Set<String> hKeys(String key);

    /**
     * 生成key.可以加上前缀
     * @param key
     * @return
     */
    String withPrefixKey(String key);


}
