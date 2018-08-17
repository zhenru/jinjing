package org.muzhe.test.demon;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author muzhe-wang on  18-8-17 下午3:38.
 */
@Component
public class UserService {

    @Cacheable(value = "muzhe-redis", key = "#user.age")
    public String saveUser(User user) {

        System.out.println("call the user " + user);
        return user.toString();

    }

}
