package org.muzhe.test.muzheCache;

import com.google.common.base.Objects;
import org.muzhe.test.muzheCache.cache.RedisCache;
import org.muzhe.test.muzheCache.util.JSONUtil;
import org.springframework.cache.Cache;

import java.util.Optional;

/**
 * 默认的Spring的cache的实现。
 * 这里是知道CacheRegistry的。否则无法获取到对应的过期时间。
 *
 * @author muzhe-wang on  18-8-15 上午11:11.
 */
public class DefaultSpringRedisCache implements Cache {

    private org.muzhe.test.muzheCache.cache.Cache cache = new RedisCache();

    private static final String DEFAULT_NULL = "";

    @Override
    public String getName() {
        return "redis-cache";
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    /**
     * 如果这个对象返回的是空的话，就会执行具体的方法
     *
     * @param cacheKeyObj 这个是要写入到缓存中对应的key
     * @return 返回从缓存中查询出来的内容并反序列化。这里使用了json来实现。
     */
    @Override
    public ValueWrapper get(Object cacheKeyObj) {

        String cacheKey = cacheKeyObj.toString();
        CacheRegistry cacheRegistry = CacheParser.parseCacheRegistry(cacheKey);
        String cacheContent = null;
        if (cacheRegistry.getMultiKey()) {
            CacheParser.Pair pair = CacheParser.generateMultiKey(cacheKey);
            cacheContent = cache.hGet(pair.getKey(), pair.getField());
        } else {
            cacheContent = cache.get(cacheKey);
        }
        System.out.println(" spring read cacheKey = " + cacheKeyObj + " cache content = " + cacheContent);

        if (cacheContent == null) {
            return null;
        } else {
            String finalCacheContent = cacheContent;
            return () -> CacheParser.parseCacheContent(cacheRegistry, finalCacheContent);
        }
    }

    @Override
    public <T> T get(Object cacheKeyObj, Class<T> type) {

        String cacheKey = cacheKeyObj.toString();
        CacheRegistry cacheRegistry = CacheParser.parseCacheRegistry(cacheKey);
        String cacheContent = null;
        if (cacheRegistry.getMultiKey()) {
            cacheContent = cache.get(cacheKey);
        } else {
            CacheParser.Pair pair = CacheParser.generateMultiKey(cacheKey);
            cacheContent = cache.hGet(pair.getKey(), pair.getField());
        }
        System.out.println(" spring read cacheKey = " + cacheKeyObj + " cache content = " + cacheContent);
        if (cacheContent == null) {
            return null;
        } else {
            String finalCacheContent = cacheContent;
            return JSONUtil.readValue(finalCacheContent, type);
        }
    }

    /**
     * 这个方法是将具体的参数写到系统中去
     *
     * @param cacheKeyObject
     * @param value
     */
    @Override
    public void put(Object cacheKeyObject, Object value) {

        String cacheKey = cacheKeyObject.toString();
        System.out.println("cache key = " + cacheKey + "valur = " + value);
        CacheRegistry cacheRegistry = CacheParser.parseCacheRegistry(cacheKey);
        String cacheContent = CacheParser.parseCacheValue(cacheRegistry, value);
        if (cacheRegistry.getMultiKey()) {
            CacheParser.Pair pair = CacheParser.generateMultiKey(cacheKey);
            cache.hSet(pair.getKey(), pair.getField(), cacheContent);
        } else {
            if (cacheRegistry.getExpireSecond() > 0) {
                cache.setEx(cacheKey, cacheContent, cacheRegistry.getExpireSecond());
            } else {
                cache.set(cacheKey, cacheContent);
            }
        }

    }

    /**
     * 这个方法是在更新后被调用的
     *
     * @param key
     */
    @Override
    public void evict(Object key) {

        String cacheKey = key.toString();
        CacheRegistry cacheRegistry = CacheParser.parseCacheRegistry(cacheKey);
        if (cacheRegistry.getMultiKey()) {
            CacheParser.Pair pair = CacheParser.generateMultiKey(cacheKey);
            cache.hDel(pair.getKey(), pair.getField());
        } else {
            cache.del(cacheKey);
        }

    }

    @Override
    public void clear() {

        //todo
        System.out.println(" clean the redis ....");
    }

    /**
     * 给null值返回一个默认空值，这样能够被写到　redis中去。
     *
     * @param cacheContent cache值
     * @return
     */
    private String toRealCacheContent(String cacheContent) {
        return Optional.ofNullable(cacheContent).orElse(DEFAULT_NULL);
    }

    /**
     * 将cache中存储的默认控制转变为　真实　的null
     *
     * @param cacheContent cache中存放的值
     * @return
     */
    private String fromRealCacheNUll(String cacheContent) {
        return DEFAULT_NULL.equals(cacheContent) ? null : cacheContent;
    }
}
