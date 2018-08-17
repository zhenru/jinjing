package org.muzhe.test.bean;

/**
 * @author muzhe-wang on  18-8-17 下午1:48.
 */
public interface CacheExpireTime {

    /**
     * 获取到过期时间,这个是如何实现的
     * @param commonCacheRegistry
     * @param cacheKey
     * @return
     */
    int getExpireTime(CommonCacheRegistry commonCacheRegistry , String cacheKey);

}
