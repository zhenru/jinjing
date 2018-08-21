package org.muzhe.test.muzheCache;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.muzhe.test.muzheCache.exceptions.LocalException;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static org.muzhe.test.muzheCache.util.Assert.assertTrue;

/**
 * CacheRegistry的仓库
 *
 * @author muzhe-wang on  18-8-20 下午2:49.
 */
@Slf4j
public class CacheRegistryRepertory {

    private static final Set<CacheRegistry> CACHE_REGISTRY_SET = Sets.newConcurrentHashSet();

    private static final Set<Integer> CACHE_TYPE_SET = Sets.newConcurrentHashSet();

    private static final Map<String, CacheRegistry> CACHE_REGISTRY_MAP = Maps.newConcurrentMap();

    static {
        log.info("start init  cache registry");
        for (CacheRegistryEnum cacheRegistry : CacheRegistryEnum.values()) {
            validCacheRegistry(cacheRegistry);
            CACHE_REGISTRY_SET.add(cacheRegistry);
            CACHE_TYPE_SET.add(cacheRegistry.getType());
            CACHE_REGISTRY_MAP.put(cacheRegistry.getKeyPrefix(), cacheRegistry);
        }
    }

    /**
     * 1.根据key前缀获取到对应的ＣacheRegistry。
     *
     * @param keyPrefix key的前缀
     * @return
     */
    public static CacheRegistry getCacheRegistry(String keyPrefix) {
        CacheRegistry cacheRegistry = CACHE_REGISTRY_MAP.get(keyPrefix);
        assertTrue(cacheRegistry != null, () -> new LocalException("没有对应的CacheRegsitry"));
        return cacheRegistry;
    }

    /**
     * 2.校验　cacheRegistry的信息
     * 保证　type和keyPrefix的唯一性
     *
     * @param cacheRegistry 缓存配置信息
     */
    private static void validCacheRegistry(CacheRegistry cacheRegistry) {

        assertTrue(cacheRegistry != null, () -> new LocalException("cache registry不能为空"));
        assertTrue(!CACHE_REGISTRY_SET.contains(cacheRegistry), () -> new LocalException("cache不能重复注册"));
        assertTrue(!CACHE_TYPE_SET.contains(cacheRegistry.getType()), () -> new LocalException("cache type不能重复"));
        assertTrue(!CACHE_REGISTRY_MAP.containsKey(cacheRegistry.getKeyPrefix()), () -> new LocalException("prefix不能为空"));
    }
}
