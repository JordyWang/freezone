package com.example.freezone.constant;

public class UserConstant {
    // 头像默认地址
    public static final String DEFAULT_AVATAR_URL = "https://www.neautotime.com/uploads/b19cb122a91d630fe24d1d8f5db84bc7.jpg";

    // 账户密码匹配表达式
    public static final String accountInvalidPattern = "[ _`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\\n|\\r|\\t";
    public static final String passwordValidPattern = "[\\w\\W]*";

    // 密码盐值
    public static final String SALT = "freezone_salt_value";

    // 注册错误代码
    public static final int REGISTER_BLANK_PARAMETER = -1;
    public static final int REGISTER_ACCOUNT_LENGTH = -2;
    public static final int REGISTER_PASSWORD_LENGTH = -3;
    public static final int REGISTER_ACCOUNT_INVALID = -4;
    public static final int REGISTER_PASSWORD_WEAK = -5;
    public static final int REGISTER_PASSWORD_DIFFERENT = -6;
    public static final int REGISTER_ACCOUNT_EXIST = -7;
    public static final int REGISTER_WRITE_FAILED = -8;


}
