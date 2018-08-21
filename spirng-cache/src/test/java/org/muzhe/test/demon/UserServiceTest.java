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

        userService.saveUser(13, "张三", Boolean.FALSE);
        System.out.println("完成了功能的测试");
        userService.saveUser(13, "张三", Boolean.FALSE);

    }

    @Test
    public void testQueryStudent() {

        String studentId = "student001";
        Student student = userService.queryStudentById(studentId);
        System.out.println(student);
    }

    @Test
    public void testQueryStudent2() {

        String studentId = "student002";
        Student student = userService.queryStudentById(studentId);
        System.out.println(student);
    }

    @Test
    public void testQueryStudent3() {

        String studentId = "student003";
        Student student = userService.queryStudentById(studentId);
        Student student1 = userService.queryStudentById(studentId);
        Student student2= userService.queryStudentById(studentId);

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);


    }
}