package org.muzhe.test.muzheCache;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.muzhe.test.demon.User;

/**
 * @author muzhe-wang on  18-8-21 下午12:35.
 */
@Getter
@AllArgsConstructor
public enum CacheRegistryEnum implements CacheRegistry {
    TEST(1, "测试的缓存", "muzhe.test", false, new Class[]{Integer.class, String.class, Boolean.class}, "测试的用户信息的类型", new TypeReference<User>() {
    }, "用户信息", 0);

    /**
     * cache的类型
     */
    private Integer type;

    /**
     * 缓存描述
     */
    private String cacheDesc;

    /**
     * key的前缀
     */
    private String keyPrefix;

    /**
     * 多key的缓存
     */
    private Boolean multiKey;

    /**
     * 缓存的参数
     */
    private Class[] parameters;

    /**
     * 参数的描述信息
     */
    private String parametersDesc;

    /**
     * 返回结果
     */
    private TypeReference resultType;

    /**
     * 结果描述信息
     */
    private String resultDesc;

    /**
     * 失效时间
     */
    private Integer expireSecond;


    @Override
    public boolean validCacheRegistry() {
        return false;
    }
}
