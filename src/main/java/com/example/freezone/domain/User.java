package com.example.freezone.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id,用户的唯一标识符,值由MyBatis自动生成
     */
    @TableId(value = "user_id")
    private Long userId;

    /**
     * 用户账户,作为用户登录的标识符
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 用户密码，用于用户登录的身份验证
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 用户昵称，用户自定义的名称
     */
    @TableField(value = "user_nickname")
    private String userNickname;

    /**
     * 用户性别，0表示男，1表示女
     */
    @TableField(value = "user_gender")
    private Integer userGender;

    /**
     * 用户头像地址
     */
    @TableField(value = "user_avatar_url")
    private String userAvatarUrl;

    /**
     * 用户签名
     */
    @TableField(value = "user_motto")
    private String userMotto;

    /**
     * 用户电子邮箱地址
     */
    @TableField(value = "user_email")
    private String userEmail;

    /**
     * 用户电话
     */
    @TableField(value = "user_tell")
    private String userTell;

    /**
     * 用户状态，0表示用户异常，1表示账户正常
     */
    @TableField(value = "user_status")
    private Integer userStatus;

    /**
     * 
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 逻辑删除，0-表示逻辑存在,1表示逻辑删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}