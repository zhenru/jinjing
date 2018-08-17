package org.muzhe.test.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author muzhe-wang on  18-8-17 下午1:44.
 */
public class CommonCacheManager {


    private static Map<CommonCacheRegistry, CacheExpireTime> cacheExpireTImeMapper = new ConcurrentHashMap<>();

    private static Map<CommonCacheRegistry, CacheKey> cacheKeyMapper = new ConcurrentHashMap<>();

    private static Map<CommonCacheRegistry, CacheParser> cacheParser = new ConcurrentHashMap<>();


    /**
     * 获取一个key
     *
     * @param registry
     * @param params
     * @return
     */
    public static String getKey(CommonCacheRegistry registry, Object... params) {

        return null;
    }


    /**
     * 获取key对应的　　过期时间
     *
     * @param registry
     * @param cacheKey
     * @return
     */
    public static int getExpireTime(CommonCacheRegistry registry, String cacheKey) {
        return 0;
    }

    /**
     * @param cacheRegistry 　　　缓存
     * @param cacheContent
     * @return
     */
    public static Object parse2Model(CommonCacheRegistry cacheRegistry, String cacheContent) {

        return null;
    }

    /**
     * 将一个对象转变为一个　Cache
     *
     * @param registry
     * @param param
     * @return
     */
    public static String parse2Cache(CommonCacheRegistry registry, Object param) {
        return null;
    }


    public static boolean isMultiKey(CommonCacheRegistry registry) {
        return false;
    }


}
