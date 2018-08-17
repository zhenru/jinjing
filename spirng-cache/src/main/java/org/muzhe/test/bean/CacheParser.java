package org.muzhe.test.bean;

/**
 * @author muzhe-wang on  18-8-17 下午2:14.
 */
public interface CacheParser {

    /**
     * 将缓存中的内容转变为一个对象
     * @param cacheContent              缓存中的内容
     * @param commonCacheRegistry       缓存对象管理策略
     * @return                          缓存对应的对象
     */
    Object parse2Model(String cacheContent, CommonCacheRegistry commonCacheRegistry);

    /**
     * 将对象转变为　cache中存放的内容
     * @param cacheModel                待缓存的对象
     * @param commonCacheRegistry       缓存对象管理策略
     * @return                          缓存的字符串
     */
    String parse2String(Object cacheModel, CommonCacheRegistry commonCacheRegistry);

}
