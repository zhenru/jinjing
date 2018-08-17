package org.muzhe.test.demon;

import org.junit.Test;
import org.muzhe.test.LocalSpringBaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-8-17 下午3:43.
 */
public class UserServiceTest extends LocalSpringBaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() {

        User user = new User();
        user.setId(12L);
        user.setAge(32);
        user.setName("你好");

        userService.saveUser(user);
        System.out.println("完成了功能的测试");
        userService.saveUser(user);

    }
}