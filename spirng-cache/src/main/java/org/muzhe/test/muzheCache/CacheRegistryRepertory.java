package org.muzhe.test.muzheCache;

import com.google.common.collect.Sets;
import org.muzhe.test.muzheCache.exceptions.LocalException;

import java.util.Collections;
import java.util.Set;

import static org.muzhe.test.muzheCache.util.Assert.assertTrue;

/**
 * @author muzhe-wang on  18-8-20 下午2:49.
 */
public class CacheRegistryRepertory {

    private static final Set<CacheRegistry> CACHE_REGISTRY_SET = Sets.newConcurrentHashSet();

    private static final Set<Integer> CACHE_TYPE_SET = Sets.newConcurrentHashSet();

    private static final Set<String> PREFIX_SET = Sets.newConcurrentHashSet();

    /**
     * 1.将cacheRegistry注册到当前仓库中
     *
     * @param cacheRegistry
     */
    public void registryCacheRegistry(CacheRegistry cacheRegistry) {

        validCacheRegistry(cacheRegistry);
        CACHE_REGISTRY_SET.add(cacheRegistry);
        CACHE_TYPE_SET.add(cacheRegistry.getTye());
        PREFIX_SET.add(cacheRegistry.getKeyPrefix());
    }

    /**
     *2.获取到所有的　cache注册列表
     * @return
     */
    public Set<CacheRegistry> getAllCacheRegistry() {
        return Collections.unmodifiableSet(CACHE_REGISTRY_SET);
    }

    /**
     * 校验　cacheRegistry的信息
     *
     * @param cacheRegistry 缓存配置信息
     */
    private void validCacheRegistry(CacheRegistry cacheRegistry) {

        assertTrue(cacheRegistry != null, () -> new LocalException("cache registry不能为空"));
        assertTrue(!CACHE_REGISTRY_SET.contains(cacheRegistry), () -> new LocalException("cache不能重复注册"));
        assertTrue(!CACHE_TYPE_SET.contains(cacheRegistry.getTye()), () -> new LocalException("cache type不能重复"));
        assertTrue(!PREFIX_SET.contains(cacheRegistry.getKeyPrefix()), () -> new LocalException("prefix不能为空"));
    }
}
