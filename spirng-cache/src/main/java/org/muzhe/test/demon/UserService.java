package org.muzhe.test.demon;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author muzhe-wang on  18-8-17 下午3:38.
 */
@Component
public class UserService {

    @Cacheable(value = "muzhe-redis", key = "1234")
    public User saveUser(String name) {

        System.out.println("call the user " + name);
        User user = new User();
        user.setId(12L);
        user.setAge(32);
        user.setName("张三");
        return user;

    }

}
