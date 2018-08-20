package org.muzhe.test.muzheCache;

/**
 * 这个类中会知道　CacheKey 和 CacheRegistry,主要是将 CacheRegistry转变为　缓存中的数据。这里也会有
 * @author muzhe-wang on  18-8-20 下午2:06.
 */
public interface CacheParser {

    /**
     * 将对应的CacheRegistry　和　生成key对应的　参数列表生成对应的key.
     * @param cacheRegistry     当前缓存对应的参数
     * @param params           生成缓存key所用到的参数
     * @return                  缓存对应的key
     */
    String parseCacheKey(CacheRegistry cacheRegistry , Object... params);


    /**
     * 根据cacheKey生成对应的CacheRegistry
     * @param cacheKey      缓存中存放的key
     * @return              CacheRegistry
     */
    CacheRegistry parseCacheRegistry(String cacheKey);

    /**
     * 将缓存对应的对象转换为String
     * @param cacheRegistry         缓存描述信息
     * @param cacheValue            缓存对象
     * @return                      缓存内容
     */
    String parseCacheValue(CacheRegistry cacheRegistry , Object cacheValue);

    /**
     * 将缓存内容转变为　对象
     * @param cacheRegistry         缓存描述信息
     * @param cacheContent          缓存内容
     * @return                      缓存对应的对象。
     */
    Object parseCacheContent(CacheRegistry cacheRegistry , String cacheContent);
}
