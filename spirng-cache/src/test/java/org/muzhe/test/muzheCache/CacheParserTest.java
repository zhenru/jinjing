package org.muzhe.test.muzheCache;

import org.junit.Test;
import org.muzhe.test.demon.User;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-8-21 上午11:16.
 */
public class CacheParserTest {

    private CacheParser cacheParser = new DefaultCacheParser();

    private int age = 12;
    private String name = "张三";
    private Boolean isLegal = Boolean.TRUE;


    @Test
    public void parseCacheKey() {

        String cacheKey = cacheParser.parseCacheKey(CacheRegistryEnum.TEST, age, name, isLegal);
        System.out.println(cacheKey);
    }

    @Test
    public void parseCacheKey2() {

        String cacheKey = cacheParser.parseCacheKey(CacheRegistryEnum.TEST);
        System.out.println(cacheKey);
    }

    @Test
    public void parseCacheRegistry() {
        String cacheKey = cacheParser.parseCacheKey(CacheRegistryEnum.TEST, age, name, isLegal);
        CacheRegistry cacheRegistry = cacheParser.parseCacheRegistry(cacheKey);
        String cacheDesc = cacheRegistry.getCacheDesc();
        System.out.println(cacheDesc);
    }

    @Test
    public void parseCacheValue() {

        User user = new User();
        user.setId(12L);
        user.setAge(23);
        user.setName("张三");

        String s = cacheParser.parseCacheValue(CacheRegistryEnum.TEST, user);
        System.out.println(s);
    }

    @Test
    public void parseCacheContent() {

        User user = new User();
        user.setId(32L);
        user.setAge(12);
        user.setName("里斯");
        String userContent = cacheParser.parseCacheValue(CacheRegistryEnum.TEST, user);
        Object o = cacheParser.parseCacheContent(CacheRegistryEnum.TEST, userContent);
        System.out.println(o.equals(user));

    }
}