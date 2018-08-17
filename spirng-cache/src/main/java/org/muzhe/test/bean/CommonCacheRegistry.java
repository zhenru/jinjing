package org.muzhe.test.bean;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import org.muzhe.test.demon.User;

import java.util.*;

/**
 * 这个表示一个方法。
 * 这里表示一个类型
 * @author muzhe-wang on  18-8-16 下午4:43.
 */
@Getter
public enum CommonCacheRegistry {

    TEST_CACHE(1, "test", new Class[]{Long.class, Integer.class, String.class},
            "测试的缓存", "三个参数表示　id, 年龄，名称", new TypeReference<List<User>>() {
    }, "测试的用户列表");

    /**
     * 类型
     */
    private int type;

    /**
     * 前缀名称
     */
    private String cacheKeyPrefix;

    /**
     * 参数类型
     */
    private Class[] paramClasses;

    /**
     * 功能描述
     */
    private String cacheDesc;

    /**
     * 参数描述
     */
    private String paramDesc;

    /**
     * Cache 内容类型
     */
    private TypeReference cacheType;

    /**
     * Cache结果类型
     */
    private String resultDesc;

    private static Map<Integer, CommonCacheRegistry> type2RegistryMapper = new HashMap<Integer, CommonCacheRegistry>();

    private static Map<String, CommonCacheRegistry> prefix2RegistryMapper = new HashMap<>();

    /**
     *将所有的类型写到Map中，同时校验系统中的type和　prefix的使用情况。
     */
    static {
        Set<Integer> typeSet = new HashSet<Integer>();
        Set<String> prefixSet = new HashSet<>();

        for (CommonCacheRegistry commonCacheRegistry : CommonCacheRegistry.values()) {
            if (typeSet.contains(commonCacheRegistry.getType())) {
                throw new RuntimeException("type:" + commonCacheRegistry.getType() + " has used.");
            }

            if (prefixSet.contains(commonCacheRegistry.getCacheKeyPrefix())) {
                throw new RuntimeException("prefix:" + commonCacheRegistry.getCacheKeyPrefix() + " has used.");
            }
            typeSet.add(commonCacheRegistry.getType());
            prefixSet.add(commonCacheRegistry.getCacheKeyPrefix());
            type2RegistryMapper.put(commonCacheRegistry.getType(), commonCacheRegistry);
            prefix2RegistryMapper.put(commonCacheRegistry.getCacheKeyPrefix(), commonCacheRegistry);
        }
    }

    CommonCacheRegistry(int type, String cacheKeyPrefix, Class[] paramClasses, String cacheDesc, String paramDesc, TypeReference typeReference, String resultDesc) {

        checkPramClass(paramClasses);
        this.type = type;
        this.cacheKeyPrefix = cacheKeyPrefix;
        this.paramClasses = paramClasses;
        this.cacheDesc = cacheDesc;
        this.paramDesc = paramDesc;
        this.cacheType = typeReference;
        this.resultDesc = resultDesc;
    }

    private void checkPramClass(Class[] paramClasses) {
        if (paramClasses == null) {
            throw new RuntimeException("param calssed mush not be null");
        }

        for (Class clazz : paramClasses) {
            if (clazz.isPrimitive()) {
                throw new RuntimeException("param class should not be primitive");
            }
        }
    }

    /**
     * 根据类型获取Cache的注册信息
     * @param type      类型
     * @return
     */
    public static final CommonCacheRegistry findByType(Integer type) {
        return type2RegistryMapper.get(type);
    }

    /**
     * 根据前缀获取对应的缓存注册信息
     * @param prefix        前缀
     * @return
     */
    public static final CommonCacheRegistry findByPrefix(String prefix) {
        return prefix2RegistryMapper.get(prefix);
    }

}
