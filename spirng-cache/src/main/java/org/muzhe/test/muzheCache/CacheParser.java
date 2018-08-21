package org.muzhe.test.muzheCache;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;
import org.muzhe.test.muzheCache.exceptions.LocalException;
import org.muzhe.test.muzheCache.util.JSONUtil;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.muzhe.test.muzheCache.util.Assert.assertTrue;

/**
 * 默认的CacheParser实现
 *
 * @author muzhe-wang on  18-8-20 下午2:47.
 */
public class CacheParser {

    private static final String SEPERATOR = ":";

    /**
     * 1.将对应的CacheRegistry　和　生成key对应的　参数列表生成对应的key.
     *
     * @param cacheRegistry 当前缓存对应的参数
     * @param params        生成缓存key所用到的参数
     * @return 缓存对应的key
     */
    public static String parseCacheKey(CacheRegistry cacheRegistry, Object... params) {

        validCacheKeyParam(cacheRegistry.getParameters(), params);
        String cacheKey = Joiner.on(SEPERATOR).
                join(Stream.of(new Object[]{cacheRegistry.getKeyPrefix()}, params)
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList()));
        return cacheKey;
    }

    /**
     * 2.根据cacheKey生成对应的CacheRegistry
     *
     * @param cacheKey 缓存中存放的key
     * @return CacheRegistry
     */
    public static CacheRegistry parseCacheRegistry(String cacheKey) {

        String keyPrefix = getKeyPrefix(cacheKey);
        return CacheRegistryRepertory.getCacheRegistry(keyPrefix);

    }

    /**
     * 3.将缓存对应的对象转换为String
     *
     * @param cacheRegistry 缓存描述信息
     * @param cacheValue    缓存对象
     * @return 缓存内容
     */
    public static String parseCacheValue(CacheRegistry cacheRegistry, Object cacheValue) {
        Type type = cacheRegistry.getValueType().getType();
        String typeName = type.getTypeName();
        if (typeName.equals(Integer.class.getTypeName()) ||
                typeName.equals(Long.class.getTypeName()) ||
                typeName.equals(Double.class.getTypeName()) ||
                typeName.equals(Short.class.getTypeName()) ||
                typeName.equals(Character.class.getTypeName()) ||
                typeName.equals(String.class.getTypeName()) ||
                typeName.equals(Boolean.class.getTypeName()) ||
                typeName.equals(Float.class.getTypeName())) {
            return cacheValue.toString();
        }

        return JSONUtil.writeValueAsString(cacheValue);
    }

    /**
     * 4.将缓存内容转变为　对象
     *
     * @param cacheRegistry 缓存描述信息
     * @param cacheContent  缓存内容
     * @return 缓存对应的对象。
     */
    public static Object parseCacheContent(CacheRegistry cacheRegistry, String cacheContent) {

        Type type = cacheRegistry.getValueType().getType();
        if (type.getTypeName().equals(Integer.class.getTypeName())) {
            return Integer.parseInt(cacheContent);
        } else if (type.getTypeName().equals(Long.class.getTypeName())) {
            return Long.parseLong(cacheContent);
        } else if (type.getTypeName().equals(Short.class.getTypeName())) {
            return Short.parseShort(cacheContent);
        } else if (type.getTypeName().equals(Float.class.getTypeName())) {
            return Float.parseFloat(cacheContent);
        } else if (type.getTypeName().equals(Boolean.class.getTypeName())) {
            return Boolean.parseBoolean(cacheContent);
        } else if (type.getTypeName().equals(String.class)) {
            return cacheContent;
        } else if (type.getTypeName().equals(Character.class.getTypeName())) {
            return cacheContent.charAt(0);
        } else if (type.getTypeName().equals(Double.class.getTypeName())) {
            return Double.parseDouble(cacheContent);
        }

        return JSONUtil.readValue(cacheContent, cacheRegistry.getValueType());
    }

    /**
     * 从cacheKey中获取到前缀
     * 其中第一个元素是前缀
     *
     * @param cacheKey
     * @return
     */
    private static String getKeyPrefix(String cacheKey) {
        assertTrue(StringUtils.isNotBlank(cacheKey), () -> new LocalException("cacheKey不能为空..."));
        return Splitter.on(SEPERATOR).split(cacheKey).iterator().next();
    }

    /**
     * 校验传递进来的　参数了参数类型是否合法
     *
     * @param parameters 生成key的参数类型是否合法
     * @param params     当前系统中的参数
     */
    private static void validCacheKeyParam(Class[] parameters, Object[] params) {
        assertTrue(parameters.length == params.length, () -> new LocalException("参数非法"));
        for (int i = 0; i < parameters.length; i++) {
            assertTrue(params[i].getClass().equals(parameters[i]), () -> new LocalException("格式不合法"));
        }
    }
}
