package org.muzhe.test.bean;

import org.muzhe.test.cache.RedisCache;
import org.muzhe.test.common.exception.CommonException;
import org.springframework.cache.Cache;

import static org.muzhe.test.common.util.Assert.assertTrue;

/**
 * 默认的Spring的cache的实现。
 *
 * @author muzhe-wang on  18-8-15 上午11:11.
 */
public class DefaultSpringRedisCache implements Cache {

    //todo
    private org.muzhe.test.cache.Cache cache = new RedisCache();


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
     * @param key
     * @return
     */
    @Override
    public ValueWrapper get(Object key) {

        System.out.println(" spring read key = " + key);
        assertTrue(key != null, () -> new CommonException("key can not null "));

        String cacheKey = key.toString();
        CommonCacheRegistry cacheRegistry = CommonCacheRegistry.findByPrefix(cacheKey);

        String cacheContent = getCacheContent(cacheKey, cacheRegistry);
        if (cacheContent == null) {
            return null;
        }
        Object model = CommonCacheManager.parse2Model(cacheRegistry, cacheContent);

        return null;

    }

    /**
     * 获取到当前缓存key对应的　内容
     *
     * @param cacheKey      cacheKey        缓存关键字
     * @param cacheRegistry cacheRegistry  　缓存注册数据
     * @return 缓存内容
     */
    private String getCacheContent(String cacheKey, CommonCacheRegistry cacheRegistry) {
        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        System.out.println(key);

        return null;
    }

    /**
     * 这个方法是将具体的参数写到系统中去
     * @param key
     * @param value
     */
    @Override
    public void put(Object key, Object value) {

        System.out.println(" key = " + key + " value = " + value);

    }

    @Override
    public void evict(Object key) {

        System.out.println("del the key  = " + key);
    }

    @Override
    public void clear() {

        System.out.println(" clean the redis ....");
    }
}
