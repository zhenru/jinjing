package org.muzhe.test.bean;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这里是一个工具类，生成一个CacheKey的实现。
 * @author muzhe-wang on  18-8-17 下午1:53.
 */
public class CacheKey {

    private boolean isMultiKey = false;

    public CacheKey(boolean multiKey) {
        this.isMultiKey = multiKey;
    }

    public CacheKey() {
        this(false);
    }

    /**
     * 获取到cache的key
     *
     * @param registry
     * @param params
     * @return
     */
    public String getKey(CommonCacheRegistry registry, Object... params) {
        if (isMultiKey()) {
            return getMultiKey(registry, params);
        } else {
            return getSingleKey(registry, params);
        }
    }

    /**
     * 单个对象的key
     *
     * @param registry
     * @param params
     * @return
     */
    private String getSingleKey(CommonCacheRegistry registry, Object... params) {

        List<Object> collect = Stream.of(new Object[]{registry.getCacheKeyPrefix()}, params).flatMap(Arrays::stream).
                collect(Collectors.toList());
        return Joiner.on(":").join(collect);

    }

    private String getMultiKey(CommonCacheRegistry registry, Object... params) {
        List<Object> collect = Stream.of(new Object[]{registry.getCacheKeyPrefix()}, params).flatMap(Arrays::stream).collect(Collectors.toList());
        String rawKey = Joiner.on(":").join(collect);
        StringBuilder sb = new StringBuilder(rawKey);
        int lastColonIndex = sb.lastIndexOf(":");
        if (lastColonIndex < 0) {
            throw new IllegalArgumentException("gen multi key failed ");
        }
        sb.replace(lastColonIndex, lastColonIndex + 1, "==");
        return sb.toString();
    }

    public final boolean isMultiKey() {
        return isMultiKey;
    }

}
