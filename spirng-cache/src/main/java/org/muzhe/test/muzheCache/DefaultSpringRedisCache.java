package org.muzhe.test.muzheCache;

import org.muzhe.test.muzheCache.cache.RedisCache;
import org.muzhe.test.util.JSONUtil;
import org.springframework.cache.Cache;

/**
 * 默认的Spring的cache的实现。
 * 这里是知道CacheRegistry的。否则无法获取到对应的过期时间。
 *
 * @author muzhe-wang on  18-8-15 上午11:11.
 */
public class DefaultSpringRedisCache implements Cache {

    //todo
    private org.muzhe.test.muzheCache.cache.Cache cache = new RedisCache();


    @Override
    public String getName() {
        return "muzhe-redis";
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    /**
     * 如果这个对象返回的是空的话，就会执行具体的方法
     *
     * @param key  这个是要写入到缓存中对应的key
     * @return      返回从缓存中查询出来的内容并反序列化。这里使用了json来实现。
     */
    @Override
    public ValueWrapper get(Object key) {

        System.out.println(" spring read key = " + key);

        String cacheKey = key.toString();

        String cacheContent = cache.get(cacheKey);

        if (cacheContent == null) {
            return null;
        } else {
            return () -> cacheContent;
        }
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        System.out.println(key);

        String cacheKey = key.toString();
        String cacheContent = cache.get(cacheKey);
        if (cacheContent != null) {
            return JSONUtil.readValue(cacheContent, type);
        }
        return null;
    }

    /**
     * 这个方法是将具体的参数写到系统中去
     *
     * @param key
     * @param value
     */
    @Override
    public void put(Object key, Object value) {

        System.out.println(" key = " + key + " value = " + value);
        String cacheKey = key.toString();
        cache.set(cacheKey, JSONUtil.writeValueAsString(value));
    }

    @Override
    public void evict(Object key) {

        System.out.println("del the key  = " + key);
        String cacheKey = key.toString();
        cache.del(cacheKey);
    }

    @Override
    public void clear() {

        System.out.println(" clean the redis ....");
    }
}
