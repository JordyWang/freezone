package com.example.freezone.service;

import com.example.freezone.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static com.example.freezone.constant.UserConstant.DEFAULT_AVATAR_URL;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceTest {

    @Resource
    private  UserService userService;

    @Test
    void testAddUser(){
        User user = new User();
        user.setUserAccount("userAccount");
        user.setUserPassword("userPassword");
        user.setUserNickname("test");
        user.setUserAvatarUrl(DEFAULT_AVATAR_URL);
        boolean res = userService.save(user);
        System.out.println(user.getUserId());
        Assertions.assertTrue(res);
    }
}




//@SpringBootTest
//class userServiceTest {
//    @Resource
//    private userService user_service;
//    @Test
//    void testAddUser(){
//        user u = new user();
//        u.setUser_id(Long.parseLong("1"));
//        u.setUser_account("wyz");
//        u.setUser_name("wyz");
//        u.setUser_pwd("wyz");
//        boolean res = user_service.save(u);
//        System.out.println(u.getUser_id());
//        Assertions.assertTrue(res);
//    }
//
//    @Test
//    void userRegister(){
//        // TODO:缺少完整的测试点
//        String userAccount = "wyzzz";
//        String userPassword = "wyzwyzwyz";
//        String checkPassword = "wyzwyzwyz";
//        long res = user_service.userRegister(userAccount, userPassword, checkPassword);
//        System.out.println(res);
//        Assertions.assertTrue(res>0);
//        userAccount = "wyz";
//        res = user_service.userRegister(userAccount, userPassword, checkPassword);
//        Assertions.assertEquals(res,-1);
//
//    }
//
//}