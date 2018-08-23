package org.muzhe.test.muzheCache;

import javafx.scene.chart.ValueAxis;
import org.apache.commons.lang.StringUtils;
import org.muzhe.test.muzheCache.exceptions.LocalException;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import static org.muzhe.test.muzheCache.util.Assert.assertTrue;

/**
 * @author muzhe-wang on  18-8-22 下午5:28.
 */
public class GuavaCache implements Cache {

    private static final Object NULL_HOLDER = new NullHolder();

    /**
     * 缓存名称
     */
    private final String name;

    /**
     * 缓存信息
     */
    private final com.google.common.cache.Cache<Object, Object> cache;

    /**
     * 是否允许空值
     */
    private final boolean allowNullValues;

    public GuavaCache(String name, com.google.common.cache.Cache cache) {
        this(name, cache, true);
    }


    public GuavaCache(String name, com.google.common.cache.Cache cache, boolean allowNullValues) {
        assertTrue(StringUtils.isNotBlank(name), () -> new LocalException("cache　name 不能为空"));

        this.name = name;
        this.cache = cache;
        this.allowNullValues = allowNullValues;
    }


    @Override
    public String getName() {
        return this.name;
    }

    /**
     * 是否允许空值
     *
     * @return
     */
    public boolean isAllowNullValues() {
        return this.allowNullValues;
    }

    @Override
    public Object getNativeCache() {
        return this.cache;
    }


    @Override
    public ValueWrapper get(Object key) {
        Object result = this.cache.getIfPresent(key);
        return result != null ? new SimpleValueWrapper(fromStoreObject(result)) : null;
    }

    /**
     * 处理一下返回的result
     *
     * @param result 缓存中存放的结果
     * @return 待处理的结果
     */
    private Object fromStoreObject(Object result) {

        return result == NULL_HOLDER ? null : result;

    }

    @Override
    public <T> T get(Object key, Class<T> type) {

        Object result = fromStoreObject(this.cache.getIfPresent(key));
        if (key != null && type != null && !type.isInstance(result)) {
            throw new RuntimeException("当前状态非法");
        }
        return (T) result;
    }

    @Override
    public void put(Object key, Object value) {
        this.cache.put(key, toStoreValue(value));
    }

    /**
     * 将vlaue变为　缓存中存放的对象
     *
     * @param value 原有的对象
     * @return 缓存中存放的对象
     */
    private Object toStoreValue(Object value) {

        if (this.allowNullValues && value == null) {
            return NULL_HOLDER;
        }
        return value;
    }

    @Override
    public void evict(Object key) {

        this.cache.invalidate(key);

    }

    @Override
    public void clear() {

        this.cache.invalidateAll();
    }

    /**
     * 这个是表示null的对象
     */
    private static class NullHolder {

    }
}
