package org.muzhe.test.demon;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author muzhe-wang on  18-8-17 下午3:38.
 */
@Component
public class UserService {

    @Cacheable(value = "redis-cache", key = "T(org.muzhe.test.muzheCache.CacheParser).parseCacheKey(T(org.muzhe.test.muzheCache.CacheRegistryEnum).TEST ,#age,#name,#isFemale)")
    public User saveUser(Integer age, String name, Boolean isFemale) {

        System.out.println("call the user  name = " + name + " age = " + age + " isFemael = " + isFemale);
        User user = new User();
        user.setId(12L);
        user.setAge(32);
        user.setName("张三");
        return user;
    }

    /**
     * 根据学生Id查询学生信息
     *
     * @param studentId 学生Ｉd
     * @return 学神信息
     */
    @Cacheable(value = "redis-cache", key = "T(org.muzhe.test.muzheCache.CacheParser).parseCacheKey(T(org.muzhe.test.muzheCache.CacheRegistryEnum).STUDENT,#studentId)")
    public Student queryStudentById(String studentId) {

        Student student = new Student();
        student.setName("张三");
        student.setId("Student0001");
        student.setAge(12);
        student.setAddress("上海市·浦东新区");
        return student;

    }

    @Cacheable(value = "redis-cache", key = "T(org.muzhe.test.muzheCache.CacheParser).parseCacheKey(T(org.muzhe.test.muzheCache.CacheRegistryEnum).CAT_TYPE,#type, #Id)")
    public Cat queryCatByType(String type, String Id) {

        Cat cat = new Cat();
        cat.setType("1");
        cat.setId("cat001");
        cat.setName("catName");
        cat.setColor("red");
        return cat;

    }

    @CacheEvict(value = "redis-cache", key = "T(org.muzhe.test.muzheCache.CacheParser).parseCacheKey(T(org.muzhe.test.muzheCache.CacheRegistryEnum).CAT_TYPE,#type,#Id)")
    public void updateCatByType(String type, String Id) {

        System.out.println("update the cat type = " + type + " Id = " + Id);

    }

    @CachePut(value = "redis-cache", key = "T(org.muzhe.test.muzheCache.CacheParser).parseCacheKey(T(org.muzhe.test.muzheCache.CacheRegistryEnum).CAT_TYPE, #type , #id)")
    public void putCatByType(String type, String id) {
        System.out.println("hello world");
    }
}
