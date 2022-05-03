package com.example.freezone.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.freezone.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author wangyizhou
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-02 02:04:04
*/
public interface UserService extends IService<User> {

    /**
     * 新用户注册
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 确认密码
     * @return  新用户id
     */
    public long userRegister(String userAccount,String userPassword,String checkPassword);


    /**
     * 用户登录
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @return  脱敏后的用户信息
     */
    public User userLogin(String userAccount, String userPassword);


    /**
     * 获取脱敏用户
     * @param user  传入从数据库取出的用户对象
     * @return  脱敏用户对象
     */
    public User getCleanUser(User user);

    /**
     *判断用户是否存在
     * @param userId    用户
     * @return  用户是否存在
     */
    public boolean checkUserId(long userId);
}



