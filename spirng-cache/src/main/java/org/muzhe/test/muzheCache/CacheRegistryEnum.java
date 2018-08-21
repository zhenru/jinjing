package org.muzhe.test.muzheCache;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.muzhe.test.demon.Cat;
import org.muzhe.test.demon.Student;
import org.muzhe.test.demon.User;

/**
 * @author muzhe-wang on  18-8-21 下午12:35.
 */
@Getter
@AllArgsConstructor
public enum CacheRegistryEnum implements CacheRegistry {

    TEST(1, "测试的缓存", "muzhe.test", false, new Class[]{Integer.class, String.class, Boolean.class}, "测试的用户信息的类型", new TypeReference<User>() {
    }, "用户信息", 1),
    STUDENT(2, "学生缓存", "muzhe.test.student", false, new Class[]{String.class}, "学生缓存，以学号为唯一标识", new TypeReference<Student>() {
    }, "学生标识", -1),
    CAT_TYPE(3, "猫的类别的缓存", "muzhe.test.cat", true, new Class[]{String.class,String.class}, "猫的信息，以Id和type作为唯一标识", new TypeReference<Cat>() {
    }, "猫的标识", -1),;

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
    private TypeReference valueType;

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
