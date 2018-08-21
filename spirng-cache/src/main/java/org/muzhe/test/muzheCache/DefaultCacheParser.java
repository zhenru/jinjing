package org.muzhe.test.muzheCache;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;
import org.muzhe.test.muzheCache.exceptions.LocalException;
import org.muzhe.test.util.JSONUtil;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.muzhe.test.muzheCache.util.Assert.assertTrue;

/**
 * 默认的CacheParser实现
 *
 * @author muzhe-wang on  18-8-20 下午2:47.
 */
public class DefaultCacheParser implements CacheParser {

    private static final String SEPERATOR = ":";

    @Override
    public String parseCacheKey(CacheRegistry cacheRegistry, Object... params) {

        validCacheKeyParam(cacheRegistry.getParameters(), params);
        String cacheKey = Joiner.on(SEPERATOR).
                join(Stream.of(new Object[]{cacheRegistry.getKeyPrefix()}, params)
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList()));
        return cacheKey;
    }

    @Override
    public CacheRegistry parseCacheRegistry(String cacheKey) {

        String keyPrefix = getKeyPrefix(cacheKey);
        return CacheRegistryRepertory.getCacheRegistry(keyPrefix);

    }

    @Override
    public String parseCacheValue(CacheRegistry cacheRegistry, Object cacheValue) {
        return JSONUtil.writeValueAsString(cacheValue);
    }

    @Override
    public Object parseCacheContent(CacheRegistry cacheRegistry, String cacheContent) {
        return JSONUtil.readValue(cacheContent, cacheRegistry.getResultType());
    }

    /**
     * 从cacheKey中获取到前缀
     * 其中第一个元素是前缀
     *
     * @param cacheKey
     * @return
     */
    private String getKeyPrefix(String cacheKey) {

        assertTrue(StringUtils.isNotBlank(cacheKey), () -> new LocalException("cacheKey不能为空..."));
        return Splitter.on(SEPERATOR).split(cacheKey).iterator().next();

    }

    /**
     * 校验传递进来的　参数了参数类型是否合法
     *
     * @param parameters 生成key的参数类型是否合法
     * @param params     当前系统中的参数
     */
    private void validCacheKeyParam(Class[] parameters, Object[] params) {

        assertTrue(parameters.length == params.length, () -> new LocalException("参数非法"));

        for (int i = 0; i < parameters.length; i++) {
            assertTrue(params[i].getClass().equals(parameters[i]), () -> new LocalException("格式不合法"));
        }

    }
}
