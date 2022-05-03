package com.example.freezone.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.freezone.domain.User;
import com.example.freezone.service.UserService;
import com.example.freezone.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.freezone.constant.UserConstant.*;

/**
* @author wangyizhou
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-02 02:04:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 用户注册
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 确认密码
     * @return  新用户id
     */
    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        // 1.检验传入参数是否有空值,则返回-1
        if (StringUtils.isAnyBlank(userAccount,userPassword,checkPassword)){
            return REGISTER_BLANK_PARAMETER;
        }

        // 2.用户账户长度在6-18位之间
        if (userAccount.length()<6 || userAccount.length()>18){
            return REGISTER_ACCOUNT_LENGTH;
        }

        // 3.用户密码长度在8-20位
        if (userPassword.length()<8 || userPassword.length()>20){
            return REGISTER_PASSWORD_LENGTH;
        }

        // 4.判断账户名中是否包含非法字符
        Matcher matcher = Pattern.compile(accountInvalidPattern).matcher(userAccount);
        if(matcher.find()){
            return REGISTER_ACCOUNT_INVALID;
        }

        // 5.检验密码强度，包含字母、数字、特殊字符
        matcher = Pattern.compile(passwordValidPattern).matcher(userPassword);
        if(!matcher.find()){
            return REGISTER_PASSWORD_WEAK;
        }

        // 6.检验密码和确认密码是否相同
        if (!userPassword.equals(checkPassword)){
            return REGISTER_PASSWORD_DIFFERENT;
        }

        // 7.检验账户是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(); // 创建查询语句
        queryWrapper.eq("user_account",userAccount);    // 查询"user_account"列值等于userAccount的记录
        long count = userMapper.selectCount(queryWrapper);  //  执行寻语句
        if (count > 0){
            return REGISTER_ACCOUNT_EXIST;
        }

        // 8.加密密码
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes(StandardCharsets.UTF_8));

        // 9.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        user.setUserNickname(userAccount);
        user.setUserAvatarUrl(DEFAULT_AVATAR_URL);
        boolean result = this.save(user);
        if(!result){
            return REGISTER_WRITE_FAILED;
        }
        return user.getUserId();
    }

    /**
     * 用户登录
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @return  脱敏后的用户信息
     */
    @Override
    public User userLogin(String userAccount, String userPassword) {
        // 1.检验传入参数是否有空值,则返回-1
        if (StringUtils.isAnyBlank(userAccount,userPassword)){
            return null;
        }

        // 2.用户账户长度在6-18位之间
        if (userAccount.length()<6 || userAccount.length()>18){
            return null;
        }

        // 3.用户密码长度在8-20位
        if (userPassword.length()<8 || userPassword.length()>20){
            return null;
        }

        // 4.判断账户名中是否包含非法字符
        Matcher matcher = Pattern.compile(accountInvalidPattern).matcher(userAccount);
        if(matcher.find()){
            return null;
        }

        // 5.检验密码强度，包含字母、数字、特殊字符
        matcher = Pattern.compile(passwordValidPattern).matcher(userPassword);
        if(!matcher.find()){
            return null;
        }

        // 6.加密密码
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes(StandardCharsets.UTF_8));

        // 7.检验账户是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(); // 创建查询语句
        queryWrapper.eq("user_account",userAccount);    // 查询"user_account"列值等于userAccount的记录
        queryWrapper.eq("user_password",encryptPassword);   // 查询"user_account"列值等于userAccount的记录
        User user = userMapper.selectOne(queryWrapper);

        // 如果没有查询到用户
        if(user==null){ // 显式标明返回null
            return null;
        }

        // 对用户信息进行脱敏并返回
        User cleanUser = getCleanUser(user);
        return cleanUser;
    }

    /**
     * 获取脱敏用户
     * @param user  传入从数据库取出的用户对象
     * @return  脱敏用户对象
     */
    @Override
    public User getCleanUser(User user) {
        User cleanUser = new User();
        cleanUser.setUserId(user.getUserId());
        cleanUser.setUserAccount(user.getUserAccount());
        cleanUser.setUserNickname(user.getUserNickname());
        cleanUser.setUserGender(user.getUserGender());
        cleanUser.setUserAvatarUrl(user.getUserAvatarUrl());
        cleanUser.setUserMotto(user.getUserMotto());
        cleanUser.setUserEmail(user.getUserEmail());
        cleanUser.setUserTell(user.getUserTell());
        return cleanUser;
    }

    /**
     *
     * @param userId    用户
     * @return
     */
    @Override
    public boolean checkUserId(long userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        long count = userMapper.selectCount(queryWrapper);
        if (count != 1){
            return true;
        }
        return false;
    }


}