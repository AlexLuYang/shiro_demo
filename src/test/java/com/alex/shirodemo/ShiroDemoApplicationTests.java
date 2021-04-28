package com.alex.shirodemo;

import com.alex.shirodemo.pojo.User;
import com.alex.shirodemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }

}
