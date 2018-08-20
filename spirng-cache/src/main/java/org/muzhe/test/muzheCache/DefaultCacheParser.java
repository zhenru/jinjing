package org.muzhe.test.muzheCache;

/**
 * 默认的CacheParser实现
 * @author muzhe-wang on  18-8-20 下午2:47.
 */
public class DefaultCacheParser implements CacheParser {

    private CacheRegistryRepertory cacheRegistryRepertory;

    @Override
    public String parseCacheKey(CacheRegistry cacheRegistry, Object... params) {


        return null;
    }

    @Override
    public CacheRegistry parseCacheRegistry(String cacheKey) {
        return null;
    }

    @Override
    public String parseCacheValue(CacheRegistry cacheRegistry, Object cacheValue) {
        return null;
    }

    @Override
    public Object parseCacheContent(CacheRegistry cacheRegistry, String cacheContent) {
        return null;
    }
}
