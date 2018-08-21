package org.muzhe.test.muzheCache;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * 缓存的描述信息，主要是cacheKey和cache之间的转换。
 *
 * @author muzhe-wang on  18-8-20 下午1:56.
 */
public interface CacheRegistry {

    /**
     * 获取缓存类型
     *
     * @return
     */
    Integer getType();

    /**
     * 获取到缓存值的描述信息
     *
     * @return
     */
    String getCacheDesc();

    /**
     * 获取key的前缀值.类似于java的java包实现。其中不能包括:这个会被校验的。
     *
     * @return
     */
    String getKeyPrefix();

    /**
     * 是否多个环境的key.如果是多环境的key,则参数至少是两个，同时最后一个是从key.前面的是主key。
     *
     * @return
     */
    Boolean getMultiKey();

    /**
     * 生成key需要使用到的参数类型
     *
     * @return
     */
    Class[] getParameters();


    /**
     * 校验参数描述信息
     *
     * @return
     */
    String getParametersDesc();

    /**
     * 获取到返回结果的类型
     *
     * @return
     */
    TypeReference getResultType();

    /**
     * 获取到结果描述信息
     *
     * @return
     */
    String getResultDesc();

    /**
     * 获取过期秒数
     *
     * @return 过期秒数
     */
    Integer getExpireSecond();

    /**
     * 校验validCacheRegistry是否合法
     *
     * @return 校验 Cache Registry的实现
     */
    boolean validCacheRegistry();

}
